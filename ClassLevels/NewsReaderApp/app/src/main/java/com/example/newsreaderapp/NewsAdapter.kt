package com.example.newsreaderapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsreaderapp.databinding.TitleItemBinding


class NewsAdapter(private val mItems: List<NewsItem>) : RecyclerView.Adapter<NewsAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = TitleItemBinding.inflate((LayoutInflater.from(parent.context)))
        return Holder(binding)
    }

    override fun getItemCount() = mItems.size

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val currentItem = mItems[position]

        // currentItem에서 필요한 데이터를 가져와서 뷰에 설정합니다.
        holder.tvTitle.text = currentItem.title
        holder.tvAgency.text = currentItem.agency
        holder.tvDate.text = currentItem.formattedDate // LocalDateTime을 문자열로 변환
        Glide.with(holder.itemView.context)
            .load(currentItem.img)
            .into(holder.newsImg) // ImageView에 이미지 표시
    }

    inner class Holder(binding: TitleItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvTitle = binding.tvTitle
        val tvAgency = binding.tvAgency
        val tvDate = binding.tvDate
        val newsImg = binding.ivImg
    }
}
