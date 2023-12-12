package com.example.foodiepal_culinarycompanion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodiepal_culinarycompanion.databinding.FragmentRecipeBinding

/**
 * A simple [Fragment] subclass.
 * Use the [RecipeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecipeFragment : Fragment() {
    private lateinit var binding:FragmentRecipeBinding
    private lateinit var recipeAdapter: RecipeAdapter
    private val recipes = mutableListOf(Recipe("Chicken Curry","Chicken, Tomato, Chilly, Masala, Garlic","1. Fry Chicken \n2. Add Masala \n3. Add Water"))
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_recipe, container, false)
        binding = FragmentRecipeBinding.bind(view)

        recipeAdapter = RecipeAdapter(recipes)
        binding.recyclerView.layoutManager= LinearLayoutManager(context)
        binding.recyclerView.adapter=recipeAdapter

        binding.addBtn.setOnClickListener{
            AddRecipeDialogFragment().show(childFragmentManager,"Add new Recipe")
        }

        return view
    }

    fun addRecipe(recipe:Recipe){
        recipes.add(recipe)
        recipeAdapter.notifyItemChanged(recipes.size-1)
    }

}