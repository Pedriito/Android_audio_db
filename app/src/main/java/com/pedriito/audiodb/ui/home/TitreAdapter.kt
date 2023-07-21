package com.pedriito.audiodb.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pedriito.audiodb.R
import com.pedriito.audiodb.api_connect.TrendingSingles

class TitreAdapter(private var titreList: List<TrendingSingles>) : RecyclerView.Adapter<TitreAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rankingText: TextView = itemView.findViewById(R.id.TexteRanking)
        val artistImage: ImageView = itemView.findViewById(R.id.imageTitreClassement)
        val artistName: TextView = itemView.findViewById(R.id.TexteTitreClassement)
        val artistName2: TextView = itemView.findViewById(R.id.TexteTitreClassement2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tritre_classement, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (artistName, artistName2) = titreList[position]
        holder.rankingText.text = "Ranking ${position + 1}"

        holder.artistName.text = artistName
        holder.artistName2.text = artistName2
    }

    override fun getItemCount(): Int {
        return titreList.size
    }

    fun updateData(newTitreList: List<TrendingSingles>) {
        Log.d("Adapter", "Updating titre list with new data: $newTitreList")

        titreList = newTitreList
        notifyDataSetChanged()
    }
}
