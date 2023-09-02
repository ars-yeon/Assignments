package com.example.newsreaderapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 더미데이터 연결
        val dummyData: List<NewsItem> = DummyData.dummyItem()

        //TitleFragment에 더미데이터 전달
        val titleFragment = TitleFragment()
        val bundle = Bundle()
        bundle.putParcelableArrayList("newsItems", ArrayList(dummyData))
        titleFragment.arguments = bundle

// TitleFragment를 화면에 추가
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, titleFragment)
            .commit()
    }
}