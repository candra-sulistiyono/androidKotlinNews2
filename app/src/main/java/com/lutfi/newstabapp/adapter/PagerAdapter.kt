package com.lutfi.newstabapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.lutfi.newstabapp.screen.news.NewsFragment
import com.lutfi.newstabapp.screen.page.PageFragment

//created by Lutfi Rizky Ramadhan on 29/04/20

class PagerAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val pages = listOf(
        PageFragment(1),
        NewsFragment(),
        PageFragment(3)
    )

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "First Tab"
            1 -> "Latest News"
            else -> "Third Tab"
        }
    }
}