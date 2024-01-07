package com.zeinabmallaki.goldapp.remote.golds

import com.zeinabmallaki.goldapp.remote.dataModel.dataModel.GoldModel
import retrofit2.Call
import retrofit2.http.GET

interface GoldApiService {

    @GET("currencies")
    fun getGolds(

    ): Call<GoldModel>
}