package com.example.foodiepal_culinarycompanion

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.example.foodiepal_culinarycompanion.databinding.FragmentAddPlanDialogBinding

class AddPlanDialogFragment : DialogFragment() {
    private lateinit var binding: FragmentAddPlanDialogBinding
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())

        val view = LayoutInflater.from(requireContext()).inflate(R.layout.fragment_add_plan_dialog,null)
        binding = FragmentAddPlanDialogBinding.bind(view)

        builder.setView(view).setTitle("Add New Plan").setPositiveButton("Add"){
                _,_ ->
            val planner = MealPlanner(binding.day.text.toString(),binding.plan.text.toString())
            (parentFragment as? MealPlannerFragment)?.let {
                it.addPlan(planner)
            }

        }
            .setNegativeButton("Cancel",null)
        return builder.create()
    }
}