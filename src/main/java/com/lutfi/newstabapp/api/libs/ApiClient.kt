package com.lutfi.newstabapp.api.libs

import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object {
        val BASE_URL = "http://18.139.222.3:9801"
        val API_KEY = "xx"

        fun create(): ApiInterface {
            val client = OkHttpClient().newBuilder()
                .addInterceptor {
                    val request: Request = it.request()
                        .newBuilder().addHeader("Authorization",
                            API_KEY
                        ).build()
                    return@addInterceptor it.proceed(request)
                }
                .build()

            val retrofit = Retrofit.Builder()
                .client(client)
                .addConverterFactory(
                    GsonConverterFactory.create()
                )
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(ApiInterface::class.java)
        }
    }
}