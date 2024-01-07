package com.zeinabmallaki.goldapp.remote.golds

import com.zeinabmallaki.goldapp.remote.dataModel.dataModel.GoldModel

interface GoldRequest {

    fun onSuccess(data: GoldModel)

    fun onNotSuccess(message:String)

    fun onError(error:String)

}