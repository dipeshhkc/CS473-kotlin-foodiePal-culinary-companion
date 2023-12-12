package com.example.foodiepal_culinarycompanion

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FoodAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 5

    override fun createFragment(position: Int): Fragment {
            return when(position){
                0 -> RecipeFragment()
                1 -> MealPlannerFragment()
                2 -> BlogFragment()
                3 -> ContactFragment()
                4 -> AboutMeFragment()
                else -> Fragment()
            }
    }
}




