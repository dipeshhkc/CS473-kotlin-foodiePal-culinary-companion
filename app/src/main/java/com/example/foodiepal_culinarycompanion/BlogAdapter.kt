package com.example.foodiepal_culinarycompanion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodiepal_culinarycompanion.databinding.BlogItemBinding

class BlogAdapter(val blogList:MutableList<Blog>):RecyclerView.Adapter<BlogAdapter.BlogViewHolder>() {

    inner class BlogViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        private val binding = BlogItemBinding.bind(itemView)
        fun bind(blogItem:Blog){
            binding.title.text= blogItem.title
            binding.blog.text=blogItem.blog
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.blog_item,parent,false)
        return BlogViewHolder(view)
    }

    override fun getItemCount()=blogList.size

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        holder.bind(blogList[position])
    }
}