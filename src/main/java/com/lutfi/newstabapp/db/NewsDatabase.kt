package com.lutfi.newstabapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lutfi.newstabapp.db.dao.NewsDao
import com.lutfi.newstabapp.db.entity.NewsEntity

//created by Lutfi Rizky Ramadhan on 29/04/20

@Database(entities = [NewsEntity::class], version = 1)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao

    companion object {
        private var instance: NewsDatabase? = null

//        private val roomCallback = object : RoomDatabase.Callback() {
//
//        }

        fun getInstance(context: Context): NewsDatabase {
            if (instance == null) {
                synchronized(NewsDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NewsDatabase::class.java, "news_database"
                    ).fallbackToDestructiveMigration()
//                        .addCallback(roomCallback)
                        .build()
                }
            }
            return instance!!
        }

        fun destroyInstance() {
            instance = null
        }
    }
}