package com.example.imagesearchapp.collection

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.imagesearchapp.data.KakaoImage
import com.example.imagesearchapp.data.SharedViewModel
import com.example.imagesearchapp.databinding.CollectionFragmentBinding


class CollectionFragment : Fragment() {

    private var _binding: CollectionFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: CollectionAdapter
    private lateinit var viewModel: SharedViewModel
    private val collectionItems = mutableListOf<KakaoImage>()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CollectionFragmentBinding.inflate(inflater, container, false)

        val recyclerView = binding.collectionRv

        viewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        adapter = CollectionAdapter(viewModel)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        sharedViewModel.getBookmarkedItems().observe(viewLifecycleOwner, Observer { bookmarkedItems ->
            adapter.submitList(bookmarkedItems.toList())
        })

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}