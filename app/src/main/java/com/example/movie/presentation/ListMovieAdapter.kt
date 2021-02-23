package com.example.movie.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.R
import com.example.movie.utils.downloadImge
import kotlinx.android.synthetic.main.item_movie.view.*

class ListMovieAdapter : RecyclerView.Adapter<ListMovieAdapter.ViewHolder>() {

    private val listData = mutableListOf<MovieItem>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    fun setData(list: List<MovieItem>) {
        listData.clear()
        listData.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.run {
            posterImg.downloadImge(listData[position].posterUrl)
            titleTxt.text = listData[position].title
        }
    }

    override fun getItemCount(): Int = listData.size
}