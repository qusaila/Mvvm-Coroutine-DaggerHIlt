package com.example.hiltwithroomandcoroutine.data.remote

import com.it.porjecttest.data.model.CheckMobileAppUpdateStatusResponse
import com.it.porjecttest.data.model.GetUserInfoResponce
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiServices {


    @GET("api/MobileAppApi/GetUserInfo")
    suspend fun getUserInfo( ): GetUserInfoResponce

}