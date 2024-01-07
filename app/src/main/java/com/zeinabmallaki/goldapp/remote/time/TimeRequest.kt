package com.zeinabmallaki.goldapp.remote.time

import com.zeinabmallaki.goldapp.remote.dataModel.dataModel.DateModel

interface TimeRequest {

    fun onSuccess(data: DateModel)

    fun onNotSuccess(message:String)

    fun onError(error:String)

}