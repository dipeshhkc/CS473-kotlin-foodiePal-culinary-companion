package com.example.foodiepal_culinarycompanion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodiepal_culinarycompanion.databinding.AboutItemBinding
import com.example.foodiepal_culinarycompanion.databinding.FragmentAboutMeBinding

/**
 * A simple [Fragment] subclass.
 * Use the [AboutMeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AboutMeFragment : Fragment(){
    private val aboutMe = mutableListOf<AboutMe>()
    private  val aboutMeAdapter= AboutMeAdapter(aboutMe)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about_me,container,false)
        val binding = FragmentAboutMeBinding.bind(view)

        binding.image.clipToOutline = true
        binding.recyclerView.adapter=aboutMeAdapter
        binding.recyclerView.layoutManager=LinearLayoutManager(context)


        val authManager = AuthManager(requireContext())
        aboutMe.add(  AboutMe("Name",authManager.getAuthenticatedUsername()))

        binding.logout.setOnClickListener {
            val authManager = AuthManager(requireContext())
            authManager.clearAuthentication()
        }

        binding.addBtn.setOnClickListener{
            AddAboutMeDialogFragment().show(childFragmentManager,"Add New Meal")
        }
        return view
    }

    fun addAboutMe(a:AboutMe){
        aboutMe.add(a)
        aboutMeAdapter.notifyItemChanged(aboutMe.size-1)

    }
}