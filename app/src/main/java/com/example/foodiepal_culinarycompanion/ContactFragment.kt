package com.example.foodiepal_culinarycompanion

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodiepal_culinarycompanion.databinding.FragmentContactBinding


class ContactFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contact,container,false)
        val binding = FragmentContactBinding.bind(view)

        binding.call.setOnClickListener{
            val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel: ${getString(R.string.chef_phone_number)}"))
            startActivity(dialIntent)
        }

        binding.email.setOnClickListener{
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto: ${getString(R.string.chef_phone_email)}?subject=Inquiry to the Chef")
                putExtra(Intent.EXTRA_SUBJECT,"Inquiry")
                putExtra(Intent.EXTRA_TEXT,"Write your inquiry here..")
            }

//            if(emailIntent.resolveActivity(requireActivity().packageManager)!=null){
                startActivity(emailIntent)
//            }
        }

        return view
    }
}