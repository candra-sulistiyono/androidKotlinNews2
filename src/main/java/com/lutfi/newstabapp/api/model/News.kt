package com.lutfi.newstabapp.api.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class News(
    @SerializedName("id")
    var newsId: Int,

    @SerializedName("category")
    var category: String,

    @SerializedName("image_url")
    var imgUrl: String,

    @SerializedName("title")
    var title: String,

    @SerializedName("content")
    var content: String
) : Parcelable