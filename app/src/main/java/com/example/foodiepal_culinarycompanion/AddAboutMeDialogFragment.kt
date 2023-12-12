package com.example.foodiepal_culinarycompanion

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.example.foodiepal_culinarycompanion.databinding.FragmentAddAboutMeBinding


/**
 * A simple [Fragment] subclass.
 * Use the [AddAboutMeDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddAboutMeDialogFragment : DialogFragment() {
    private lateinit var binding: FragmentAddAboutMeBinding
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())

        val view = LayoutInflater.from(requireContext()).inflate(R.layout.fragment_add_about_me,null)
        binding = FragmentAddAboutMeBinding.bind(view)

        builder.setView(view).setTitle("Add New Detail").setPositiveButton("Add"){
                _,_ ->
            val aboutMe = AboutMe(binding.title.text.toString(),binding.detail.text.toString())
            (parentFragment as? AboutMeFragment)?.let {
                it.addAboutMe(aboutMe)
            }

        }
            .setNegativeButton("Cancel",null)
        return builder.create()
    }
}