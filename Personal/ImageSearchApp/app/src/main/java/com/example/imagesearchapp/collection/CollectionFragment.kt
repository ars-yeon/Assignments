package com.example.imagesearchapp.collection

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.imagesearchapp.data.SharedViewModel
import com.example.imagesearchapp.databinding.CollectionFragmentBinding


class CollectionFragment : Fragment() {

    private var _binding: CollectionFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: CollectionAdapter
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CollectionFragmentBinding.inflate(inflater, container, false)

        val recyclerView = binding.collectionRv

        adapter = CollectionAdapter(sharedViewModel)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        sharedViewModel.bookmarkedItems.observe(viewLifecycleOwner, Observer { bookmarkedItems ->
            adapter.submitList(bookmarkedItems.toList())
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel.loadBookmarks(requireContext())
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}