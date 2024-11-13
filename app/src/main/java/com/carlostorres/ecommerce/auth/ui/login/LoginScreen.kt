package com.carlostorres.ecommerce.auth.ui.login

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.carlostorres.ecommerce.auth.presentation.login.LoginViewModel
import com.carlostorres.ecommerce.auth.ui.login.components.LoginContent

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    navigateToRegister: () -> Unit,
) {

    val state = viewModel.state

    Scaffold { paddingValues ->

        LoginContent(
            paddingValues = paddingValues,
            state = state,
            onEvent = { event ->
                viewModel.onEvent(event)
            },
            navigateToRegister = { navigateToRegister() }
        )

    }

}
