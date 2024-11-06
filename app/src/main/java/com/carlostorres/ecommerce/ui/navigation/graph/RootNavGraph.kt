package com.carlostorres.ecommerce.ui.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.carlostorres.ecommerce.ui.navigation.Graph

@Composable
fun RootNavGraph(
    //navController: NavHostController
) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ){

        AuthenticationNavGraph(navController = navController)

    }

}