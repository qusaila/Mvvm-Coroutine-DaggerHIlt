package com.it.porjecttest.base

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import androidx.lifecycle.ViewModel
import com.it.porjecttest.utils.ApiStatus
import com.it.porjecttest.utils.Constants
import retrofit2.HttpException
import java.lang.Exception

open class BaseViewModel: ViewModel {


    constructor() {
    }



    fun isInternetConnected(application: Application): Boolean {
        val conMgr =
            application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = conMgr.activeNetworkInfo
        return if (netInfo == null) false else true
    }
    fun handellErrorCode(  ex: Exception): ApiStatus {

        if (ex is HttpException) {
            when (ex.code()) {

                Constants.UNAUTHORIZED -> {
                    return ApiStatus.UNAUTHORIZED
                }
                Constants.CONFLICT -> {
                    return ApiStatus.CONFLICT

                }
                else->
                    return ApiStatus.ERROR



            }
        }else
            return ApiStatus.ERROR

    }

}