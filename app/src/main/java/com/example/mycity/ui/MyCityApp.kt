package com.example.mycity.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityApp() {

    //Manages app navigation within a NavHost
    val navController = rememberNavController()
    val viewModel: MyCityViewModel = viewModel()

    //The navController will trigger a re-compose whenever the user nagivates to a new screen on the stack,
    // causing this to update to the current back stack entry (whatever is on top of stack now)
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = backStackEntry?.destination?.route ?: "MyCityHomeScreen"
        // ?. is a null save call operator, returning either the object.property value, or NULL if the object is null



    Scaffold(
        topBar = {
            MyCityAppToppAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
                modifier = Modifier
            )
        },
    ) { innerPadding ->

        val uiState by viewModel.uiState.collectAsState()

        //TODO: update route names to be Enums
        NavHost(
            //Use of inner padding will allow content to be padded in accordance with any AppBars that are added to the scaffolding
            navController = navController,
            startDestination = "myCityHomeScreen",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = "MyCityHomeScreen") {
                MyCityHomeScreen(onCategoryClicked = {
                    viewModel.updateSelectedCategory(category = it)
                    navController.navigate("MyCityCategoryRecommendationsScreen")
                })
            }
            composable(route = "MyCityCategoryRecommendationsScreen") {
                MyCityCategoryRecommendationsScreen(myCityUiState = uiState,
                    onRecommendationClicked = {
                        viewModel.updateSelectedReccomendation(reccomendation = it)
                        navController.navigate("MyCityCategoryRecommendationDetailsScreen")
                    })
            }
            composable(route = "MyCityCategoryRecommendationDetailsScreen") {
                uiState.selectedReccomendation?.let { it1 ->
                    MyCityCategoryRecommendationDetailsScreen(
                        it1
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityAppToppAppBar(
    currentScreen: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TopAppBar(colors = TopAppBarDefaults.smallTopAppBarColors(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        titleContentColor = MaterialTheme.colorScheme.primary,
    ), title = {
        Text(currentScreen)
    }, navigationIcon = {
        if (canNavigateBack) {
            IconButton(onClick = navigateUp) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "navigate back"
                )
            }
        }
    })

}