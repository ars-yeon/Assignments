package com.example.contactlistapp

import android.content.ContentResolver
import android.content.Context
import android.database.Cursor
import android.provider.ContactsContract

class ContactFetcher(private val context: Context) {
    fun fetchContacts(): List<Contact> {
        val contactsList = mutableListOf<Contact>()
        val contentResolver: ContentResolver = context.contentResolver
        val cursor: Cursor? = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            null,
            null,
            null
        )

        cursor?.let {
            val photoUriColumnIndex = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI)
            val nameColumnIndex = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
            val phoneNumberColumnIndex = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
            val favoriteColumnIndex = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.STARRED)

            while (it.moveToNext()) {
                val Img: String? = it.getString(photoUriColumnIndex)
                val name: String = it.getString(nameColumnIndex)
                val tel: String = it.getString(phoneNumberColumnIndex)
                val favoriteString: String = it.getString(favoriteColumnIndex)
                val favorite: Boolean = favoriteString.toBoolean()

                contactsList.add(Contact(Img, name, tel, favorite))
            }
            it.close()
        }
        return contactsList
    }
}