package com.example.imagesearchapp.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.imagesearchapp.collection.CollectionFragment
import com.example.imagesearchapp.search.SearchFragment

class PagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    private val fragments = listOf(
        TabModel(SearchFragment(), "Search"),
        TabModel(CollectionFragment(), "Collection")
    )

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments[position].fragment
    }
}