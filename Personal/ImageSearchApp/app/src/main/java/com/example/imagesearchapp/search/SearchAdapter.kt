package com.example.imagesearchapp.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.imagesearchapp.R
import com.example.imagesearchapp.data.KakaoImage
import com.example.imagesearchapp.databinding.RvItemBinding

class SearchAdapter(private var items: MutableList<KakaoImage>) :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        Glide.with(holder.itemView.context)
            .load(item.thumbnailUrl)
            .placeholder(R.drawable.gif_loading)
            .error(R.drawable.img_notfound)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(holder.itemImage)

        holder.itemText.text = item.siteName
        holder.itemDate.text = item.datetime
            .substringBeforeLast(".")
            .replace("T", " ")
            .substring(0, 16)
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val itemImage = binding.itemImg
        val itemText = binding.itemName
        val itemDate = binding.itemDate
    }
}