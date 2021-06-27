package com.it.porjecttest.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData

import com.example.myapplicationtest.repository.UserReposetory
import com.it.porjecttest.MyApp
import com.it.porjecttest.base.BaseViewModel
import com.it.porjecttest.data.model.GetUserInfoResponce
import com.it.porjecttest.data.model.Resource
import com.it.porjecttest.utils.ApiStatus

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject


@HiltViewModel

class LauchViewModel : BaseViewModel {

    var repo: UserReposetory
    var data: MutableLiveData<GetUserInfoResponce>

    @Inject
    constructor(repo: UserReposetory) {
        this.repo = repo
        data = MutableLiveData(GetUserInfoResponce())
    }

    fun getUser() = liveData(Dispatchers.IO) {
        if (isInternetConnected(MyApp.getInstance())) {
            emit(Resource.loading(data = null))
            try {
                val res = repo.getData()
                data.postValue(res)
                emit(Resource.success(data = res))


            } catch (exception: Exception) {
                emit(
                    Resource.error(
                        data = null, status = handellErrorCode(exception)
                    )
                )
            }
        } else {
            emit(
                Resource.error(
                    data = null, status = ApiStatus.NOINTERNETCONNECTION
                )
            )
        }

    }

    fun getLiveData(): LiveData<GetUserInfoResponce> {

        return data

    }
}
