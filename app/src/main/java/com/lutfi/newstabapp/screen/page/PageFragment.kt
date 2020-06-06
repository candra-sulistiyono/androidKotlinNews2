package com.lutfi.newstabapp.screen.page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.lutfi.newstabapp.R
import kotlinx.android.synthetic.main.fragment_page.*

/**
 * A simple [Fragment] subclass.
 */
class PageFragment(var page: Int) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        txtPage.text = getString(R.string.txt_page, page)
    }
}
