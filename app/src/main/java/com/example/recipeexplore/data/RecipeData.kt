package com.example.recipeexplore.data

import com.example.recipeexplore.model.Recipe
import com.example.recipes.R
import com.example.recipes.model.Recipe

object RecipeData {
    val defaultRecipe = getRecipesData()[0]
    fun getRecipesData(): List<Recipe> {
        return listOf(
            Recipe(
                id = 1,
                titleResourceId = R.string.spaghetti_name,
                recipeDetails = R.string.spaghetti_desc
            ),
            Recipe(
                id = 2,
                titleResourceId = R.string.curry_name,
                recipeDetails = R.string.curry_desc
            ),
            Recipe(
                id = 3,
                titleResourceId = R.string.stroganoff_name,
                recipeDetails = R.string.stroganoff_desc
            )
        )
    }
}