package com.example.applemarketapp

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import com.example.applemarketapp.databinding.ActivityDetailBinding
import java.text.DecimalFormat

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private var isLike = false

    private val itemPosition: Int by lazy {
        intent.getIntExtra(Constants.ITEM_INDEX, 0)
    }

    private val item: SaleItem? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(Constants.ITEM_INDEX, SaleItem::class.java)
        } else {
            intent.getParcelableExtra<SaleItem>(Constants.ITEM_OBJECT)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivItemImg.setImageDrawable(item?.let {
            ResourcesCompat.getDrawable(resources, it.Image, null)
        })

        binding.tvSellerName.text = item?.SellerName
        binding.tvAddress.text = item?.Address
        binding.tvItemTitle.text = item?.ItemTitle
        binding.tvItemContent.text = item?.ItemDetail
        binding.tvPrice.text = DecimalFormat("#,###").format(item?.Price) + "원"
        isLike = item?.isLike == true
    }
}