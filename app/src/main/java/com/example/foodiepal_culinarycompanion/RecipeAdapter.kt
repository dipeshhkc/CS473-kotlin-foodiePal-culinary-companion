package com.example.foodiepal_culinarycompanion

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.foodiepal_culinarycompanion.databinding.RecipeItemBinding

class RecipeAdapter(private val recipes:MutableList<Recipe>):RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecipeAdapter.RecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_item,parent,false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeAdapter.RecipeViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.bind(recipe)
    }

    override fun getItemCount()=recipes.size

    inner class RecipeViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {

        private var binding:RecipeItemBinding =RecipeItemBinding.bind(itemView)
        fun bind(recipe: Recipe){
           binding.title.text= recipe.name
           binding.ingredient.text=recipe.ingredients
           binding.instruction.text=recipe.instructions
            binding.shareBtn.setOnClickListener{
                val sendIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    type = "text/plain"
                    putExtra(Intent.EXTRA_SUBJECT, recipe.name)
                    putExtra(Intent.EXTRA_TEXT, "${recipe.ingredients}\n${recipe.instructions}")
                }

                // Start the activity with the share intent
                it.context.startActivity(Intent.createChooser(sendIntent, "Share ${recipe.name}"))
            }
       }
    }
}