package com.lutfi.newstabapp.db.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.lutfi.newstabapp.db.entity.NewsEntity
import com.lutfi.newstabapp.db.repository.NewsRepository

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {
    fun insert(news: NewsEntity) {
        if (getNews(news.newsId) != null) {
            Log.d("Insert News : ", "Existed ${news.newsId}")
        } else {
            Log.d("Insert News : ", "OK ${news.newsId}")
            newsRepository.insert(news)
        }
    }

    fun getAllNews(): LiveData<List<NewsEntity>> {
        return newsRepository.getAllNews()
    }

    fun getNews(newsId: Int): NewsEntity? {
        return newsRepository.getNews(newsId)
    }
}