package com.example.foodiepal_culinarycompanion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.view.get
import androidx.core.view.size
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.foodiepal_culinarycompanion.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.TabGravity
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foodAdapter = FoodAdapter(this)
        binding.views.adapter = foodAdapter

        TabLayoutMediator(binding.tabs, binding.views) { tab, position ->

            when (position) {
                0 -> {
                    tab.text = "Recipe"
                }

                1 -> {
                    tab.text = "Meal Planner"
                }

                2 -> {
                    tab.text = "Blog"
                }

                3 -> {
                    tab.text = "Contact"
                }

                4 -> {
                    tab.text = "About Me"
                }
            }
        }.attach()


        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.recipe -> binding.views.setCurrentItem(0,true)
                R.id.mealPlanner -> binding.views.setCurrentItem(1,true)
                R.id.blog -> binding.views.setCurrentItem(2,true)
            }
            true
        }
    }

}