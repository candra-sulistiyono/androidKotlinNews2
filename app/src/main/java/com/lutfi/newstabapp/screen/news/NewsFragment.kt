package com.lutfi.newstabapp.screen.news

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.lutfi.newstabapp.R
import com.lutfi.newstabapp.adapter.NewsAdapter
import com.lutfi.newstabapp.api.libs.ApiClient
import com.lutfi.newstabapp.api.model.BaseResponse
import com.lutfi.newstabapp.api.model.News
import com.lutfi.newstabapp.db.entity.NewsEntity
import com.lutfi.newstabapp.db.viewmodel.NewsViewModel
import com.lutfi.newstabapp.screen.detail.DetailActivity
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.android.synthetic.main.toolbar.*
import org.koin.android.ext.android.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class NewsFragment : Fragment(), NewsAdapter.OnItemClickListener {

    private val apiClient by lazy {
        ApiClient.create()
    }
    private lateinit var newsAdapter: NewsAdapter
    private val newsViewModel: NewsViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getNewsFromApi()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
        newsAdapter = NewsAdapter(this)
        rvNews.layoutManager = LinearLayoutManager(context)
        rvNews.setHasFixedSize(true)
        rvNews.adapter = newsAdapter
    }

    private fun getNewsFromApi() {
        apiClient.getNews()
            .enqueue(object : Callback<BaseResponse<List<News>>> {
                override fun onFailure(
                    call: Call<BaseResponse<List<News>>>,
                    t: Throwable
                ) {
                    Toast.makeText(
                        context,
                        getString(R.string.msg_getnews_error),
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.d("getNews : ", t.message)
                }

                override fun onResponse(
                    call: Call<BaseResponse<List<News>>>,
                    response: Response<BaseResponse<List<News>>>
                ) {
                    if (response.isSuccessful) {
                        checkAndInsertData(response.body()!!.data)
                    } else {
                        Toast.makeText(
                            context,
                            getString(R.string.msg_getnews_error),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            })
    }

    private fun checkAndInsertData(newsList: List<News>) {
        newsList.forEach {
            val news = NewsEntity(
                it.newsId,
                it.category,
                it.imgUrl,
                it.title,
                it.content
            )
            newsViewModel.insert(news)
        }
        getNewsFromDatabase()
    }

    private fun getNewsFromDatabase() {
        newsViewModel.getAllNews().observe(this, Observer { list ->
            list.let { newsAdapter.setNews(it) }
        })
    }

    override fun onItemClicked(news: NewsEntity) {
//        Toast.makeText(this, news.title, Toast.LENGTH_SHORT).show()
        DetailActivity.start(context!!, news)
    }
}
