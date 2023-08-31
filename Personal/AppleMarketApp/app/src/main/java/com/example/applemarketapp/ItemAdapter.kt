package com.example.applemarketapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarketapp.databinding.ItemBinding

class ItemAdapter(private val mItems: MutableList<SaleItem>) :
    RecyclerView.Adapter<ItemAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemImg.setImageResource(mItems[position].Image)
        holder.tvTitle.text = mItems[position].ItemTitle
        holder.tvAddress.text = mItems[position].Address
        holder.tvPrice.text = mItems[position].Price.toString()
        holder.tvChat.text = mItems[position].ChatCnt.toString()
        holder.tvLike.text = mItems[position].LikeCnt.toString()
    }

    inner class Holder(binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val itemImg = binding.ivItemImg
        val tvTitle = binding.tvItemTitle
        val tvAddress = binding.tvAddress
        val tvPrice = binding.tvPrice
        val tvChat = binding.tvChat
        val tvLike = binding.tvLike
    }
}
