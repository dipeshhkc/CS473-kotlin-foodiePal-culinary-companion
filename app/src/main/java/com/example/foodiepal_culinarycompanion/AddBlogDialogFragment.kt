package com.example.foodiepal_culinarycompanion

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.DialogFragment
import com.example.foodiepal_culinarycompanion.databinding.FragmentAddBlogDialogBinding
import com.example.foodiepal_culinarycompanion.databinding.FragmentAddPlanDialogBinding

/**
 * A simple [Fragment] subclass.
 * Use the [AddBlogDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddBlogDialogFragment : DialogFragment() {
    private lateinit var binding: FragmentAddBlogDialogBinding
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())

        val view = LayoutInflater.from(requireContext()).inflate(R.layout.fragment_add_blog_dialog,null)

        binding = FragmentAddBlogDialogBinding.bind(view)

        builder.setView(view).setTitle("Add New Blog").setPositiveButton("Add"){
                _,_ ->
            val blog = Blog(binding.title.text.toString(),binding.blog.text.toString())
            (parentFragment as? BlogFragment)?.let {
                it.addBlog(blog)
            }

        }
            .setNegativeButton("Cancel",null)
        return builder.create()
    }
}