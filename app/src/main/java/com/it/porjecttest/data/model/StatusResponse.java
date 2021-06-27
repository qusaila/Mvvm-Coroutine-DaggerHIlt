package com.it.porjecttest.data.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StatusResponse {

    @SerializedName("Status")
    @Expose
    private Status Status;

    public Status getStatus() {
        return Status;
    }

    public void setStatus(Status status) {
        Status = status;
    }
}


//Status
//        :
//        {ID: 0, RowID: 0, ErrorMessage: "Success", ExceptionMessage: null, IsSuccess: true,…}