package com.pedriito.audiodb.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pedriito.audiodb.R
import com.pedriito.audiodb.api_connect.TrendingAlbum


class AlbumAdapter(private val albumList: List<TrendingAlbum>) : RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    // ViewHolder class to hold the views
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rankingText: TextView = itemView.findViewById(R.id.TexteRankingAlbum)
        val albumImage: ImageView = itemView.findViewById(R.id.imageAlbumClassement)
        val albumTitle: TextView = itemView.findViewById(R.id.texteAlbumClassement)
        val albumTitle2: TextView = itemView.findViewById(R.id.texteAlbumClassement2)
    }


    // Create ViewHolders and inflate the item layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_album_classement, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (albumTitle, albumTitle2) = albumList[position]
        holder.rankingText.text = "Ranking ${position + 1}"
        holder.albumTitle.text = albumTitle
        holder.albumTitle2.text = albumTitle2
    }

    override fun getItemCount(): Int {
        return albumList.size
    }


}

