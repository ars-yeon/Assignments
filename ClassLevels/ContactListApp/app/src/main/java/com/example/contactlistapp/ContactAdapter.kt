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
import android.Manifest
import com.bumptech.glide.Glide
import com.example.contactlistapp.databinding.ContactItemAfBinding
import com.example.contactlistapp.databinding.ContactItemBfBinding

class ContactAdapter(private val mItems: List<Contact>, internal val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val CALL_PERMISSION_REQUEST_CODE = 1
    private val VIEW_TYPE_NORMAL = 0
    private val VIEW_TYPE_FAVORITE = 1

    override fun getItemViewType(position: Int): Int {
        val contact = mItems[position]
        return if (contact.aFavorite) {
            VIEW_TYPE_FAVORITE // 즐겨찾기된 아이템
        } else {
            VIEW_TYPE_NORMAL // 일반 아이템
        }
    }

    // 뷰 홀더 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == VIEW_TYPE_FAVORITE) {
            // 즐겨찾기 아이템의 레이아웃 인플레이션
            val AfBinding = ContactItemAfBinding.inflate(inflater, parent, false)
            AfViewHolder(AfBinding)
        } else {
            // 일반 아이템의 레이아웃 인플레이션
            val bfBinding = ContactItemBfBinding.inflate(inflater, parent, false)
            BfViewHolder(bfBinding)
        }
    }

    // 아이템 클릭 이벤트 인터페이스
    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null  // 아이템 클릭 리스너

    // 뷰 홀더에 데이터 바인딩
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = mItems[position] // 현재 위치의 아이템 가져오기

        when (holder) {
            is BfViewHolder -> {
                Glide.with(context)
                    .load(item.aImg)
                    .into(holder.bfImg)
                holder.bfName.text = item.aName
                holder.bfTel.text = item.aTel

                holder.bfCall.setOnClickListener {
                    itemClick?.onClick(it, position)

                    val phoneNumber = item.aTel
                    val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                    if (ContextCompat.checkSelfPermission(
                            context,
                            Manifest.permission.CALL_PHONE
                        ) == PackageManager.PERMISSION_GRANTED
                    ) {
                        context.startActivity(dialIntent)
                    } else {
                        ActivityCompat.requestPermissions(
                            context as Activity,
                            arrayOf(Manifest.permission.CALL_PHONE),
                            CALL_PERMISSION_REQUEST_CODE
                        )
                    }
                }

                holder.bfFavorite.setOnClickListener {
                    item.aFavorite = !item.aFavorite
                    notifyItemChanged(position)
                }
                if (!item.aFavorite) {
                    holder.bfFavorite.setImageResource(R.drawable.ic_star_empty)
                }
            }

            is AfViewHolder -> {
                holder.afFavorite.setOnClickListener {
                    item.aFavorite = !item.aFavorite
                    notifyItemChanged(position)
                }
                if (item.aFavorite) {
                    holder.afFavorite.setImageResource(R.drawable.ic_star_filled)
                }

                holder.afCall.setOnClickListener {
                    itemClick?.onClick(it, position)

                    val phoneNumber = item.aTel
                    val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                    if (ContextCompat.checkSelfPermission(
                            context,
                            Manifest.permission.CALL_PHONE
                        ) == PackageManager.PERMISSION_GRANTED
                    ) {
                        context.startActivity(dialIntent)
                    } else {
                        ActivityCompat.requestPermissions(
                            context as Activity,
                            arrayOf(Manifest.permission.CALL_PHONE),
                            CALL_PERMISSION_REQUEST_CODE
                        )
                    }
                }

                holder.afName.text = item.aName
                holder.afTel.text = item.aTel
                Glide.with(context)
                    .load(item.aImg)
                    .into(holder.afImg)
            }
        }
    }

    // 아이템 개수 반환
    override fun getItemCount(): Int {
        return mItems.size
    }

    // 뷰 홀더 클래스
    inner class BfViewHolder(binding: ContactItemBfBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val bfImg = binding.bfImgItem // 프로필 이미지 뷰
        val bfName = binding.bfNameItem // 이름 텍스트뷰
        val bfTel = binding.bfTelItem // 전화번호 텍스트뷰
        val bfCall = binding.bfCallItem // 전화 아이콘 이미지뷰
        val bfFavorite = binding.bfFavoriteItem // 즐겨찾기 아이콘 이미지뷰
    }

    inner class AfViewHolder(binding: ContactItemAfBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val afImg = binding.afImgItem // 프로필 이미지 뷰
        val afName = binding.afNameItem // 이름 텍스트뷰
        val afTel = binding.afTelItem // 전화번호 텍스트뷰
        val afCall = binding.afCallItem // 전화 아이콘 이미지뷰
        val afFavorite = binding.afFavoriteItem // 즐겨찾기 아이콘 이미지뷰
    }
}
