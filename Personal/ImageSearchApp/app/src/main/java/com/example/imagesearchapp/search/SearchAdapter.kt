package com.example.imagesearchapp.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.imagesearchapp.R
import com.example.imagesearchapp.data.KakaoImage
import com.example.imagesearchapp.data.SharedViewModel
import com.example.imagesearchapp.databinding.RvItemBinding

class SearchAdapter(private var items: MutableList<KakaoImage>, private val viewModel: SharedViewModel) :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    private var bookmarkedItems: Set<KakaoImage> = emptySet()

    init {
        viewModel.bookmarkedItems.observeForever { items ->
            bookmarkedItems = items
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val itemImage = binding.itemImg
        private val itemText = binding.itemName
        private val itemDate = binding.itemDate
        private val itemBookmark = binding.itemBookmark

        init {
            itemBookmark.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val clickedItem = items[position]
                    clickedItem.isBookmarked = !clickedItem.isBookmarked
                    notifyItemChanged(position)

                    viewModel.toggleBookmark(clickedItem)
                }
            }
        }

        fun bind(item: KakaoImage) {
            Glide.with(itemView.context)
                .load(item.thumbnailUrl)
                .placeholder(R.drawable.gif_loading)
                .error(R.drawable.img_notfound)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(itemImage)

            itemText.text = "[Image]" + item.siteName
            itemDate.text = item.datetime
                .substringBeforeLast(".")
                .replace("T", " ")
                .substring(0, 16)

            setBookmark(item.isBookmarked)
        }

        private fun setBookmark(isBookmarked: Boolean) {
            val bookmarkDrawable = if (isBookmarked) R.drawable.ic_bookmark_filled else R.drawable.ic_bookmark_empty
            val bookmarkColor = if (isBookmarked) R.color.violet else R.color.gray3

            itemBookmark.setImageResource(bookmarkDrawable)
            itemBookmark.setColorFilter(ContextCompat.getColor(itemView.context, bookmarkColor))
        }
    }
}