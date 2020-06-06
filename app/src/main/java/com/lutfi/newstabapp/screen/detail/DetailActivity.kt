package com.lutfi.newstabapp.screen.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.lutfi.newstabapp.R
import com.lutfi.newstabapp.db.entity.NewsEntity
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.toolbar.*

class DetailActivity : AppCompatActivity() {

    private var news: NewsEntity? = null

    companion object {
        const val KEY_NEWS = "key_news"
        fun start(context: Context, news: NewsEntity) {
            val starter = Intent(context, DetailActivity::class.java)
            starter.putExtra(KEY_NEWS, news)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initIntent()
        initUi()
    }

    private fun setupToolbar(toolbar: Toolbar, title: String) {
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar!!.title = title
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun initIntent() {
        news = intent.getParcelableExtra(KEY_NEWS)
    }

    private fun initUi() {
        setupToolbar(toolbarApp, news!!.title)
        tvDetailTitle.text = news!!.title
        tvDetailCategory.text = news!!.category
        tvDetailContent.text = news!!.content
        Glide.with(this).load(news!!.imgUrl).into(imgDetail)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
