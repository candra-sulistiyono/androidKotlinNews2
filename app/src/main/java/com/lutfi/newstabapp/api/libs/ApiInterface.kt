package com.lutfi.newstabapp.api.libs

import com.lutfi.newstabapp.api.model.BaseResponse
import com.lutfi.newstabapp.api.model.News
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("api/news")
    fun getNews(): Call<BaseResponse<List<News>>>
}