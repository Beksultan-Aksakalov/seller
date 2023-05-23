package com.example.sellerapp.data.network

import com.example.sellerapp.core.framework.network.Failure
import com.example.sellerapp.data.network.dto.ErrorRes
import com.google.gson.Gson
import retrofit2.HttpException

fun HttpException.apiError(): Failure.ApiError? {
    val errorBody = this.response()?.errorBody()?.string()
    return errorBody?.let {
        val errorRes = Gson().fromJson(errorBody, ErrorRes::class.java)
        Failure.ApiError(errorRes.errorCode, errorRes.errorDescr)
    }
}