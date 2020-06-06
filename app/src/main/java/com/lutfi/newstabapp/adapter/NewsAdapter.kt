package com.lutfi.newstabapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lutfi.newstabapp.R
import com.lutfi.newstabapp.db.entity.NewsEntity

class NewsAdapter(val itemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<NewsAdapter.NewsHolder>() {
    private var news: List<NewsEntity> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return NewsHolder(itemView)
    }

    override fun getItemCount(): Int {
        return news.size
    }

    fun setNews(news: List<NewsEntity>) {
        this.news = news
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        val currentNews = news[position]
        holder.bind(currentNews, itemClickListener)
    }

    class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtTitle: TextView = itemView.findViewById(R.id.txtTitle)
        var txtMedia: TextView = itemView.findViewById(R.id.txtMedia)
        var imgNews: ImageView = itemView.findViewById(R.id.imgNews)

        fun bind(news: NewsEntity, itemClickListener: OnItemClickListener) {
            txtTitle.text = news.title
            txtMedia.text = news.category
            Glide.with(itemView).load(news.imgUrl).into(imgNews)

            itemView.setOnClickListener{
                itemClickListener.onItemClicked(news)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClicked(news: NewsEntity)
    }
}