package com.example.contactlistapp

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contactlistapp.databinding.ContactItemBinding

class ContactAdapter(private val mItems: List<Contact>, internal val context: Context) :
    RecyclerView.Adapter<ContactAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.Holder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ContactAdapter.Holder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    // 뷰 홀더 클래스
    inner class Holder(val binding: ContactItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val img = binding.imgItem // 프로필 이미지 뷰
        val name = binding.nameItem // 이름 텍스트뷰
        val tel = binding.telItem // 전화번호 텍스트뷰
        val favorite = binding.favoriteItem // 즐겨찾기 아이콘 이미지뷰
    }
}
