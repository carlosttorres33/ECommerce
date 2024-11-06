package com.carlostorres.ecommerce.ui.auth.login

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.carlostorres.ecommerce.ui.auth.login.components.LoginContent

@Composable
fun LoginScreen(
    navigateToRegister: () -> Unit
) {

    Scaffold { paddingValues ->

        LoginContent(
            paddingValues = paddingValues,
            navigateToRegister = { navigateToRegister() }
        )

    }

}

