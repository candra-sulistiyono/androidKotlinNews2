package com.lutfi.newstabapp.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.lutfi.newstabapp.db.entity.NewsEntity

@Dao
interface NewsDao {
    @Insert
    fun insertNews(news: NewsEntity)

    @Query("SELECT * FROM table_news")
    fun getAllNews(): LiveData<List<NewsEntity>>

    @Query("SELECT * FROM table_news WHERE newsId IS :newsId")
    fun getNews(newsId: Int): NewsEntity?
}