package com.lutfi.newstabapp.api.model

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("code")
    var code: Int,

    @SerializedName("data")
    var data: T,

    @SerializedName("message")
    var msg: String,

    @SerializedName("status")
    var status: String
)