package com.example.recipeexplore.model

import androidx.annotation.StringRes

data class Recipe(
    val id: Int,
    @StringRes val nameResourceId: Int,
    @StringRes val recipeDetailsId: Int
    )