package com.carlostorres.ecommerce.ui.navigation.screens

sealed class AuthenticationScreens(val route: String) {
    data object Login : AuthenticationScreens("login")
    data object Register : AuthenticationScreens("register")
}