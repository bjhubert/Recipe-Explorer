package com.example.recipeexplore.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.recipeexplore.data.RecipeData
import com.example.recipeexplore.model.Recipe

@Composable
fun RecipeListScreen(
    recipes: List<Recipe> = RecipeData.recipes){
    LazyColumn (
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
        item {
            Text(
                text = "Recipe List",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
        items(recipes, key = {it.id}) { recipe ->
            RecipeCard(recipe = recipe,
            onClick = {})
        }
    }
}
@Composable
//dad helped me with this section
private fun RecipeListItem(
    recipe: Recipe,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ){
        Column(modifier = Modifier.padding(16.dp)){
            Text(
                text = stringResource(recipe.nameResourceId),
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = stringResource(recipe.recipeDetailsId),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}