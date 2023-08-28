package com.example.contactlistapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.contactlistapp.databinding.ContactItemBinding
import android.Manifest

private val CALL_PERMISSION_REQUEST_CODE = 1

class ContactAdapter(private val mItems: List<Contact>, internal val context: Context) :
    RecyclerView.Adapter<ContactAdapter.Holder>() {

    // 뷰 홀더 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.Holder {
        val binding = ContactItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    // 아이템 클릭 이벤트 인터페이스
    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null  // 아이템 클릭 리스너

    // 뷰 홀더에 데이터 바인딩
    override fun onBindViewHolder(holder: ContactAdapter.Holder, position: Int) {
        val item = mItems[position] // 현재 위치의 아이템 가져오기

        holder.img.setImageResource(item.aImg) // 프로필 이미지 설정
        holder.name.text = item.aName // 이름 설정
        holder.tel.text = item.aTel // 전화번호 설정

        // 아이템 뷰 클릭 이벤트 처리
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position) // 아이템 클릭 리스너 호출

            val phoneNumber = item.aTel // 해당 위치의 전화번호 가져오기
            val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            // 권한이 있는지 확인
            if (ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.CALL_PHONE
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                // 이미 권한이 허용된 경우 바로 전화 걸기 동작 수행
                context.startActivity(dialIntent)
            } else {
                // 권한이 없는 경우 권한 요청
                ActivityCompat.requestPermissions(
                    context as Activity, // 주의: context가 Activity 타입이어야 합니다.
                    arrayOf(Manifest.permission.CALL_PHONE),
                    CALL_PERMISSION_REQUEST_CODE
                )
            }
        }

        // 즐겨찾기 아이콘 클릭 이벤트 처리
        holder.favorite.setOnClickListener {
            item.aFavorite = !item.aFavorite
            notifyItemChanged(position)
        }

        // 즐겨찾기 상태에 따라 아이콘 변경
        if (item.aFavorite) {
            holder.favorite.setImageResource(R.drawable.ic_star_filled)
        } else {
            holder.favorite.setImageResource(R.drawable.ic_star_empty)
        }
    }

    // 아이템 개수 반환
    override fun getItemCount(): Int {
        return mItems.size
    }

    // 뷰 홀더 클래스
    inner class Holder(binding: ContactItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val img = binding.imgItem // 프로필 이미지 뷰
        val name = binding.nameItem // 이름 텍스트뷰
        val tel = binding.telItem // 전화번호 텍스트뷰
        val favorite = binding.favoriteItem // 즐겨찾기 아이콘 이미지뷰
    }
}
