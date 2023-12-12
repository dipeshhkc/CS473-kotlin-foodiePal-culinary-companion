package com.example.foodiepal_culinarycompanion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodiepal_culinarycompanion.databinding.MealPlanItemBinding
import com.example.foodiepal_culinarycompanion.databinding.RecipeItemBinding

class MealPlannerAdapter(val plans:MutableList<MealPlanner>):RecyclerView.Adapter<MealPlannerAdapter.MealPlannerViewHolder>() {

    inner class MealPlannerViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val binding = MealPlanItemBinding.bind(itemView)
        fun bind(plan:MealPlanner){
            binding.plan.text = plan.plan
            binding.day.text = plan.day
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MealPlannerViewHolder {
        val view=LayoutInflater.from(p0.context).inflate(R.layout.meal_plan_item,p0,false)
        return MealPlannerViewHolder(view)
    }

    override fun getItemCount()=plans.size

    override fun onBindViewHolder(p0: MealPlannerViewHolder, p1: Int) {
        p0.bind(plans[p1])
    }
}