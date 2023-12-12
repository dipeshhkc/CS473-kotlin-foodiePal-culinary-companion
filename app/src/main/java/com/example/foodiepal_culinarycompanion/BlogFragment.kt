package com.example.foodiepal_culinarycompanion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodiepal_culinarycompanion.databinding.FragmentBlogBinding


/**
 * A simple [Fragment] subclass.
 * Use the [BlogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlogFragment : Fragment(){
    private val blogList= mutableListOf(Blog("Intro to Kotlin","The importance of Mobile device programming has emerged over the recent years as a new domain in software development. This program prepares the students to develop applications that run on mobile devices such as an iPhone, iPads, or Android phones."))
    private val adapter = BlogAdapter(blogList)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blog,container,false)
        val binding = FragmentBlogBinding.bind(view)


        binding.recyclerView.adapter=adapter
        binding.recyclerView.layoutManager=LinearLayoutManager(context)

        binding.addBtn.setOnClickListener {
            AddBlogDialogFragment().show(childFragmentManager,"Add New Blog")
        }
        return view
    }

    fun addBlog(blog:Blog){
        blogList.add(blog)
        adapter.notifyItemChanged(blogList.size-1)
    }
}
