package com.example.contactlistapp

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactlistapp.databinding.ActivityMainBinding
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val CALL_PERMISSION_REQUEST_CODE = 1

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

    // 권한 요청 결과 처리 메서드
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == CALL_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 권한 허용 시 동작 수행
                // 이 부분에 아이템 클릭 시의 동작을 넣거나 해당 동작을 호출하세요.
            } else {
                // 권한 거부 시 알림 표시
                Toast.makeText(this, "전화 걸기 권한을 허용해야 합니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}