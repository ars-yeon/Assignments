package com.example.imagesearchapp.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.imagesearchapp.R
import com.example.imagesearchapp.data.SharedViewModel
import com.example.imagesearchapp.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { MainActivityBinding.inflate(layoutInflater) }
    private val viewPager by lazy { binding.fragmentContainer }
    private val bottomNav by lazy { binding.bottomNavi }
    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViewPager()
        initNavigationBar()
    }

    private fun initViewPager() {
        val adapter = PagerAdapter(this)
        viewPager.adapter = adapter
    }

    private fun initNavigationBar() {
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navi_search -> viewPager.currentItem = 0
                R.id.navi_collection -> viewPager.currentItem = 1
            }
            true
        }
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                when (position) {
                    0 -> bottomNav.selectedItemId = R.id.navi_search
                    1 -> bottomNav.selectedItemId = R.id.navi_collection
                }
            }
        })
        bottomNav.selectedItemId = R.id.navi_search
    }
}