package com.example.foodiepal_culinarycompanion

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.foodiepal_culinarycompanion.databinding.AboutItemBinding

class AboutMeAdapter (private val aboutMe:MutableList<AboutMe>): RecyclerView.Adapter<AboutMeAdapter.AboutMeViewHolder>() {

    inner class AboutMeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = AboutItemBinding.bind(itemView)
        fun bind(a:AboutMe){
            binding.title.text = a.title
            binding.detail.text = a.detail
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AboutMeViewHolder {
        val view= LayoutInflater.from(p0.context).inflate(R.layout.about_item,p0,false)
        return AboutMeViewHolder(view)
    }

    override fun getItemCount()=aboutMe.size

    override fun onBindViewHolder(p0: AboutMeViewHolder, p1: Int) {
        p0.bind(aboutMe[p1])
    }
}



