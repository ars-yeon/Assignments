package com.example.contactlistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactlistapp.databinding.ActivityMainBinding
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val dataList = ContactData.contactData()

        binding.recyclerView.adapter = ContactAdapter(dataList, this)

        val adapter = ContactAdapter(dataList, this)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)


        // 아이템 클릭을 감지하고 처리
        adapter.itemClick = object: ContactAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val name: String = dataList[position].aName
                Toast.makeText(this@MainActivity, " $name 님에게 전화를 겁니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}