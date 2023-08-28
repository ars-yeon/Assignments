package com.example.contactlistapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contactlistapp.databinding.ContactItemBinding

class ContactAdapter(private val mItems: List<Contact>, internal val context: Context) :
    RecyclerView.Adapter<ContactAdapter.Holder>() {

    // 뷰 홀더 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.Holder {
        val binding = ContactItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    // 뷰 홀더에 데이터 바인딩
    override fun onBindViewHolder(holder: ContactAdapter.Holder, position: Int) {
        val item = mItems[position] // 현재 위치의 아이템 가져오기

        holder.img.setImageResource(item.aImg) // 프로필 이미지 설정
        holder.name.text = item.aName // 이름 설정
        holder.tel.text = item.aTel // 전화번호 설정
    }

    // 아이템 개수 반환
    override fun getItemCount(): Int {
        return mItems.size
    }

    // 뷰 홀더 클래스
    inner class Holder(val binding: ContactItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val img = binding.imgItem // 프로필 이미지 뷰
        val name = binding.nameItem // 이름 텍스트뷰
        val tel = binding.telItem // 전화번호 텍스트뷰
        val favorite = binding.favoriteItem // 즐겨찾기 아이콘 이미지뷰
    }
}
