package com.example.imagesearchapp.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imagesearchapp.R
import com.example.imagesearchapp.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { MainActivityBinding.inflate(layoutInflater) }
    private val viewPager by lazy { binding.fragmentContainer }
    private val bottomNav by lazy {binding.bottomNavi}

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
        bottomNav.selectedItemId = R.id.navi_search
    }
}