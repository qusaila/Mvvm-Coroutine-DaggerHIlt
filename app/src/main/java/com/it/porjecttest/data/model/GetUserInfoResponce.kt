package com.it.porjecttest.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetUserInfoResponce : StatusResponse() {
    @SerializedName("Data")
    @Expose
    var student: Student? = null

}