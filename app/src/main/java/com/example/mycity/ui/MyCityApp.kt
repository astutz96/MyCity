package com.example.mycity.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyCityApp() {

    //Manages app navigation within a NavHost
    val navController = rememberNavController()

    Text("MyCityApp")

    NavHost(
        navController = navController, startDestination = "home", modifier = Modifier
    ) {
        composable(route = "home"){

        }
    }

}