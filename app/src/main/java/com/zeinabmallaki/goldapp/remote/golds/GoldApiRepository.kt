package com.zeinabmallaki.goldapp.remote.golds

import com.zeinabmallaki.goldapp.remote.MainRetrofitService
import com.zeinabmallaki.goldapp.remote.dataModel.dataModel.DateModel
import com.zeinabmallaki.goldapp.remote.dataModel.dataModel.GoldModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GoldApiRepository private constructor(){

    companion object {
        private var apiRepository: GoldApiRepository? = null

        val instance: GoldApiRepository
            get() {
                if (apiRepository == null) apiRepository = GoldApiRepository()
                return apiRepository!!

            }

    }

    fun getGolds(
        request: GoldRequest

    ){

        MainRetrofitService.goldApiService.getGolds().enqueue(
            object : Callback<GoldModel>{
                override fun onResponse(call: Call<GoldModel>, response: Response<GoldModel>) {

                    if (response.isSuccessful){

                        val data = response.body() as GoldModel
                        request.onSuccess(data)
                    }else
                        request.onNotSuccess("Not Success")
                }

                override fun onFailure(call: Call<GoldModel>, t: Throwable) {

                    request.onError("Error : ${t.message}")


                }

            }
        )
    }
}