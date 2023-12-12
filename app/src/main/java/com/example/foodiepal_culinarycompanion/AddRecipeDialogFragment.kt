package com.example.foodiepal_culinarycompanion

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.example.foodiepal_culinarycompanion.databinding.FragmentAddRecipeDialogBinding



class AddRecipeDialogFragment: DialogFragment() {

    private lateinit var binding: FragmentAddRecipeDialogBinding
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())

        val view = LayoutInflater.from(requireContext()).inflate(R.layout.fragment_add_recipe_dialog,null)
        binding = FragmentAddRecipeDialogBinding.bind(view)

        builder.setView(view).setTitle("Add New Recipe").setPositiveButton("Add"){
            _,_ ->
                val recipe = Recipe(binding.name.text.toString(),binding.ingredient.text.toString(),binding.instruction.text.toString())
            (parentFragment as? RecipeFragment)?.let {
                it.addRecipe(recipe)
            }

        }
            .setNegativeButton("Cancel",null)
        return builder.create()
    }
}