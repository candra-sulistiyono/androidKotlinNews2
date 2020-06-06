package com.lutfi.newstabapp.db.repository

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.lutfi.newstabapp.db.dao.NewsDao
import com.lutfi.newstabapp.db.entity.NewsEntity

class NewsRepository(private val newsDao: NewsDao) {
    fun insert(news: NewsEntity) {
        InsertNewsAsyncTask(newsDao).execute(news)
    }

    fun getAllNews(): LiveData<List<NewsEntity>> {
        return newsDao.getAllNews()
    }

    fun getNews(newsId: Int): NewsEntity? {
        return GetNewsAsyncTask(newsDao).execute(newsId).get()
    }

    private class InsertNewsAsyncTask(val newsDao: NewsDao) : AsyncTask<NewsEntity, Unit, Unit>() {
        override fun doInBackground(vararg params: NewsEntity?) {
            newsDao.insertNews(params[0]!!)
        }
    }

    private class GetNewsAsyncTask(val newsDao: NewsDao) :
        AsyncTask<Int, Unit, NewsEntity?>() {
        override fun doInBackground(vararg params: Int?): NewsEntity? {
            return newsDao.getNews(params[0]!!)
        }
    }
}