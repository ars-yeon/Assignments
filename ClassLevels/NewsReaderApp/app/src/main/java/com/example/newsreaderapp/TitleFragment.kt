package com.example.newsreaderapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class TitleFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private val mItems: List<NewsItem> = DummyData.dummyItem()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_title, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = NewsAdapter(mItems)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter.itemClick = object : NewsAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val clickedNewsItem = mItems[position]
                val bundle = Bundle()
                bundle.putInt(Constants.NEWS_INDEX, position)
                bundle.putParcelable(Constants.NEWS_OBJECT, clickedNewsItem)

                val detailFragment = DetailFragment.newInstance(clickedNewsItem)
                detailFragment.arguments = bundle

                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.fragment_container,
                        detailFragment
                    )
                    .addToBackStack(null)
                    .commit()
            }
        }

        return view
    }
}