package com.example.noticeapp.Adapter

import android.media.Image
import android.provider.ContactsContract
import java.net.URL

data class Notice(
    val id : Int,
    val title : String,
  /*  val description : String,*/
    val url: String,
    val thumbnailURL: String
)
