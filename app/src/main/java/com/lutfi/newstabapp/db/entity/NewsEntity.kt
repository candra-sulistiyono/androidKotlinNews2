package com.lutfi.newstabapp.db.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "table_news")
data class NewsEntity(var newsId: Int, var category: String, var imgUrl: String, var title: String, var content: String) :
    Parcelable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}