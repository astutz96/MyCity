package com.example.mycity.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityApp() {

    //Manages app navigation within a NavHost
    val navController = rememberNavController()
    val viewModel: MyCityViewModel = viewModel()

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("My City")
                }
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
                Text("MyCityCategoryRecommendationsScreen")
            }
            composable(route = "MyCityCategoryRecommendationDetailsScreen") {
                Text("MyCityCategoryRecommendationDetailsScreen")
            }
        }
    }
}