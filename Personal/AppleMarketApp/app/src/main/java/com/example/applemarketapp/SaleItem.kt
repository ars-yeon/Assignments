package com.example.applemarketapp

data class SaleItem(
    val Image: Int,
    val ItemTitle: String,
    val ItemDetail: String,
    val SellerName: String,
    val Price: Int,
    val Address: String,
    var LikeCnt: Int,
    val ChatCnt: Int,
    var isLike: Boolean
)