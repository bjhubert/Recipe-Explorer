package com.example.recipeexplore.ui

import androidx.lifecycle.ViewModel
import com.example.recipeexplore.data.RecipeData
import com.example.recipeexplore.model.Recipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class RecipeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        RecipeUiState(
            recipes = RecipeData.recipes,
            currentRecipe = RecipeData.defaultRecipe,
            isShowingListPage = true
        )
    )
    val uiState: StateFlow<RecipeUiState> = _uiState
    fun selectRecipe(recipe: Recipe) {
        _uiState.update {
            it.copy(currentRecipe = recipe)
        }
    }

    fun showList() {
        _uiState.update { it.copy(isShowingListPage = true) }
    }

    fun showDetail() {
        _uiState.update { it.copy(isShowingListPage = false) }
    }
}
data class RecipeUiState(
    val recipes: List<Recipe> = emptyList(),
    val currentRecipe: Recipe = RecipeData.defaultRecipe,
    val isShowingListPage: Boolean = true
)