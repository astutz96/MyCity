package com.example.mycity.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycity.MyCityHomeScreen

@Composable
fun MyCityApp() {

    //Manages app navigation within a NavHost
    val navController = rememberNavController()

    //TODO: update route names to be Enums
    NavHost(
        navController = navController, startDestination = "myCityHomeScreen", modifier = Modifier
    ) {
        composable(route = "MyCityHomeScreen"){
            MyCityHomeScreen()
        }
        composable(route = "MyCityCategoryRecommendationsScreen"){
            Text("MyCityCategoryRecommendationsScreen")
        }
        composable(route = "MyCityCategoryRecommendationDetailsScreen"){
            Text("MyCityCategoryRecommendationDetailsScreen")
        }
    }

}