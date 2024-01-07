package com.zeinabmallaki.goldapp.remote

import com.zeinabmallaki.goldapp.remote.golds.GoldApiService
import com.zeinabmallaki.goldapp.remote.time.TimeApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MainRetrofitService {

    private const val url = "https://tools.daneshjooyar.com/api/v1/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: TimeApiService = retrofit.create(TimeApiService::class.java)
    val goldApiService: GoldApiService = retrofit.create(GoldApiService::class.java)
}