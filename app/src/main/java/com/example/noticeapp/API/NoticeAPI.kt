package com.example.noticeapp.API

import com.example.noticeapp.Adapter.Notice
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface NoticeAPI {

    @GET("photos")
    suspend fun getNotices(): Response<List<Notice>>
}