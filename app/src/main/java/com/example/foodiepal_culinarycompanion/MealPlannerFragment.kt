package com.example.foodiepal_culinarycompanion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodiepal_culinarycompanion.databinding.FragmentMealPlannerBinding


class MealPlannerFragment : Fragment(){
    private val planner = mutableListOf<MealPlanner>(MealPlanner("Sunday","1.Breakfast:Bread \n2.Lunch:Chicken \n3.Dinner:Rice"),
        MealPlanner("Monday","1.Breakfast:Conflex \n2.Lunch:Sea Food \n3.Dinner:Pork"))
    private  val plannerAdapter= MealPlannerAdapter(planner)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_meal_planner,container,false)
        val binding = FragmentMealPlannerBinding.bind(view)

        binding.recyclerView.layoutManager= LinearLayoutManager(context)
        binding.recyclerView.adapter=plannerAdapter

        binding.addBtn.setOnClickListener{
            AddPlanDialogFragment().show(childFragmentManager,"Add New Meal")
        }

        return view
    }

    fun addPlan(plan:MealPlanner){
        planner.add(plan)
        plannerAdapter.notifyItemChanged(planner.size-1)

    }
}