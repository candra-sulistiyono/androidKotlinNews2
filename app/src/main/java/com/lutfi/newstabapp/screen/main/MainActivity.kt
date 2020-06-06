package com.lutfi.newstabapp.screen.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.lutfi.newstabapp.R
import com.lutfi.newstabapp.adapter.PagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUi()
    }

    private fun initUi(){
        setupToolbar(toolbarApp, getString(R.string.activity_main))
        vpMain.adapter = PagerAdapter(supportFragmentManager)
        tabMain.setupWithViewPager(vpMain)
    }

    private fun setupToolbar(toolbar: Toolbar, title: String) {
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar!!.title = title
        }
    }
}
