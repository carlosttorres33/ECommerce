package com.carlostorres.ecommerce.ui.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.carlostorres.ecommerce.ui.auth.login.LoginScreen
import com.carlostorres.ecommerce.ui.auth.register.RegisterScreen
import com.carlostorres.ecommerce.ui.navigation.Graph
import com.carlostorres.ecommerce.ui.navigation.screens.AuthenticationScreens

fun NavGraphBuilder.AuthenticationNavGraph(navController: NavHostController) {

    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthenticationScreens.Login.route
    ){

        composable(
            route = AuthenticationScreens.Login.route
        ){
            LoginScreen(
                navigateToRegister = {
                    navController.navigate(AuthenticationScreens.Register.route)
                }
            )
        }

        composable(
            route = AuthenticationScreens.Register.route
        ){
            RegisterScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

    }

}