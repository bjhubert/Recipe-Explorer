package com.example.recipeexplore.data

import com.example.recipeexplore.R
import com.example.recipeexplore.model.Recipe

object RecipeData {
    val recipes: List<Recipe> = listOf(
            Recipe(
                id = 1,
                nameResourceId = R.string.spaghetti_name,
                recipeDetailsId = R.string.spaghetti_desc
            ),
            Recipe(
                id = 2,
                nameResourceId = R.string.curry_name,
                recipeDetailsId = R.string.curry_desc
            ),
            Recipe(
                id = 3,
                nameResourceId = R.string.stroganoff_name,
                recipeDetailsId = R.string.stroganoff_desc
            ),
        )
        val defaultRecipe: Recipe = recipes.first()
    }