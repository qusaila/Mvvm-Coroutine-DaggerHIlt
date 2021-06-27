package com.example.myapplicationtest.repository

import android.util.Log
import androidx.lifecycle.liveData
import com.example.hiltwithroomandcoroutine.data.remote.ApiServices
import com.it.porjecttest.data.model.CheckMobileAppUpdateStatusRequest
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import javax.inject.Inject

class UserReposetory {

    var apiService: ApiServices

    @Inject
    constructor(apiService: ApiServices) {
        this.apiService = apiService


    }

    suspend fun getData() = apiService.getUserInfo()


}