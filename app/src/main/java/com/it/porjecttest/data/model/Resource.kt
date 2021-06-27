package com.it.porjecttest.data.model

import com.it.porjecttest.utils.ApiStatus


data class Resource<out T>(val status: ApiStatus, val data: T? ) {
    companion object {
        fun <T> success(data: T): Resource<T> = Resource(status = ApiStatus.SUCCESS, data = data)

        fun <T> error(data: T? ,status: ApiStatus): Resource<T> =
                Resource(status =status, data = data )



        fun <T> loading(data: T?): Resource<T> = Resource(status = ApiStatus.LOADING, data = data)
    }
}