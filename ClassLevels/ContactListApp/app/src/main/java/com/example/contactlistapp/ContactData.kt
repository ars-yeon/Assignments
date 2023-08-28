package com.example.contactlistapp

object ContactData {
    fun contactData(): List<Contact> {
        val dataList = mutableListOf<Contact>()
        dataList.add(Contact(R.drawable.img_0, "김철수", "010-0000-0000", false))
        dataList.add(Contact(R.drawable.img_1, "맹구", "010-1111-1111", false))
        dataList.add(Contact(R.drawable.img_2, "봉미선", "010-2222-2222", false))
        dataList.add(Contact(R.drawable.img_3, "신짱구", "010-3333-3333", false))
        dataList.add(Contact(R.drawable.img_4, "신짱아", "010-4444-4444", false))
        dataList.add(Contact(R.drawable.img_5, "신형만", "010-5555-5555", false))
        dataList.add(Contact(R.drawable.img_6, "이훈이", "010-6666-6666", false))
        dataList.add(Contact(R.drawable.img_7, "한수지", "010-7777-7777", false))
        dataList.add(Contact(R.drawable.img_8, "한유리", "010-8888-8888", false))
        dataList.add(Contact(R.drawable.img_9, "흰둥이", "010-9999-9999", false))
        return dataList
    }
}