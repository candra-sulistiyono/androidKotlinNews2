package com.lutfi.newstabapp.di

import com.lutfi.newstabapp.adapter.NewsAdapter
import com.lutfi.newstabapp.db.NewsDatabase
import com.lutfi.newstabapp.db.repository.NewsRepository
import com.lutfi.newstabapp.db.viewmodel.NewsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dbModule = module {
    single { NewsDatabase.getInstance(get()) }
    factory { get<NewsDatabase>().newsDao() }
}

val repositoryModule = module {
    single { NewsRepository(get()) }
}

val uiModule = module {
    factory { NewsAdapter(get()) }
    viewModel { NewsViewModel(get()) }
}