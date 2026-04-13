package com.example.recipeexplore.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.recipeexplore.model.Recipe

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeApp(
    windowSize: WindowWidthSizeClass,
    onBackPressed: () -> Unit
) {
    val viewModel: RecipeViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()
    if (!uiState.isShowingListPage) {
        BackHandler { viewModel.showList() }
    } else {
        BackHandler { onBackPressed() }
    }


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = if (uiState.isShowingListPage) "Recipe List"
                        else stringResource(uiState.currentRecipe.nameResourceId)
                    )
                }
            )
        }
    ) { padding ->
        if (uiState.isShowingListPage) {
            RecipeListScreen(
                recipes = uiState.recipes,
                contentPadding = padding,
                onClick = { recipe ->
                    viewModel.selectRecipe(recipe)
                    viewModel.showDetail()
                }
            )
        } else {
            RecipeDetailScreen(
                recipe = uiState.currentRecipe,
                contentPadding = padding
            )
        }
    }
}

@Composable
fun RecipeListScreen(
    recipes: List<Recipe>,
    onClick: (Recipe) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(
        contentPadding = contentPadding,
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        items(recipes) { recipe ->
            RecipeListItem(
                recipe = recipe,
                onClick = { onClick(recipe) },
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}

@Composable
fun RecipeListItem(
    recipe: Recipe,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = stringResource(recipe.nameResourceId),
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = stringResource(recipe.recipeDetailsId),
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 1,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

@Composable
fun RecipeDetailScreen(
    recipe: Recipe,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    Column(
        modifier = Modifier.padding(
            start = 16.dp,
            top = contentPadding.calculateTopPadding(),
            end = 16.dp,
            bottom = 16.dp
        )
    ) {
        Text(
            text = stringResource(recipe.recipeDetailsId),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 12.dp)
        )
    }
}
