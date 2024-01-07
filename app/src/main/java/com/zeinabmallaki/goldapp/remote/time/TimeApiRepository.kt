package com.zeinabmallaki.goldapp.remote.time

import com.zeinabmallaki.goldapp.remote.MainRetrofitService
import com.zeinabmallaki.goldapp.remote.dataModel.dataModel.DateModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TimeApiRepository private constructor(){

    companion object {
        private var apiRepository: TimeApiRepository? = null

        val instance: TimeApiRepository
            get() {
                if (apiRepository == null) apiRepository = TimeApiRepository()
                return apiRepository!!

            }

    }

    fun getTime(
        request: TimeRequest

    ){

        MainRetrofitService.apiService.getTime(true).enqueue(
            object : Callback<DateModel>{
                override fun onResponse(call: Call<DateModel>, response: Response<DateModel>) {

                    if (response.isSuccessful){

                        val data = response.body() as DateModel
                        request.onSuccess(data)
                    }else
                        request.onNotSuccess("Not Success")
                }

                override fun onFailure(call: Call<DateModel>, t: Throwable) {

                    request.onError("Error : ${t.message}")


                }

            }
        )
    }
}