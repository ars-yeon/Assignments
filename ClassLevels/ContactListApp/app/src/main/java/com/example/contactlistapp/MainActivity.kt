package com.example.contactlistapp

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactlistapp.databinding.ActivityMainBinding
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val READ_CONTACTS_PERMISSION_REQUEST_CODE = 100
    private val CALL_PHONE_PERMISSION_REQUEST_CODE = 123
    private var isContactsPermissionGranted = false
    private var isDialPermissionGranted = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        /*
        // 더미 데이터
        val dataList = ContactData.contactData()
        binding.recyclerView.adapter = ContactAdapter(dataList, this)
        */

        // 사용자가 주소록 퍼미션 허용했는지 확인
        val status = ContextCompat.checkSelfPermission(this, "android.permission.READ_CONTACTS")
        if (status == PackageManager.PERMISSION_GRANTED) {
            isContactsPermissionGranted = true
            loadContacts()
        } else {
            // 퍼미션 요청 다이얼로그 표시
            ActivityCompat.requestPermissions(
                this,
                arrayOf<String>("android.permission.READ_CONTACTS"),
                READ_CONTACTS_PERMISSION_REQUEST_CODE
            )
        }
    }

    // 권한 요청 결과 처리 메서드
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            READ_CONTACTS_PERMISSION_REQUEST_CODE -> {
                // 주소록 퍼미션 허용 처리
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    isContactsPermissionGranted = true
                    loadContacts()
                } else {
                    Log.d("test", "permission denied")
                    Toast.makeText(this, "주소록 읽기 권한을 허용해야 합니다.", Toast.LENGTH_SHORT).show()
                }
            }
            CALL_PHONE_PERMISSION_REQUEST_CODE -> {
                // 전화걸기 퍼미션 허용 처리
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    isDialPermissionGranted = true
                } else {
                    Log.d("test", "permission denied")
                    Toast.makeText(this, "전화 걸기 권한을 허용해야 합니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun loadContacts() {
        val contactFetcher = ContactFetcher(this)
        val dataList = contactFetcher.fetchContacts()
        val adapter = ContactAdapter(dataList, this)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.itemClick = object : ContactAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val name: String = dataList[position].aName

                if (!isDialPermissionGranted) {
                    // 전화걸기 퍼미션 요청
                    ActivityCompat.requestPermissions(
                        this@MainActivity,
                        arrayOf(android.Manifest.permission.CALL_PHONE),
                        CALL_PHONE_PERMISSION_REQUEST_CODE
                    )
                } else {
                    // 전화걸기 권한이 허용된 경우 토스 메시지 띄우기
                    Toast.makeText(this@MainActivity, "$name 님에게 전화를 겁니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}
