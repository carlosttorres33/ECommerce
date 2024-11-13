package com.carlostorres.ecommerce.auth.ui.register

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.carlostorres.ecommerce.auth.presentation.register.RegisterViewModel
import com.carlostorres.ecommerce.auth.ui.register.components.RegisterContent
import com.carlostorres.ecommerce.ui.components.DefaultTopBar
import com.carlostorres.ecommerce.ui.theme.Blue500

@Preview(showSystemUi = true)
@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel = hiltViewModel(),
    onBackClick: () -> Unit = {}
) {

    val state = viewModel.state

    Scaffold(
        topBar = {
            DefaultTopBar(
                upAvailable = true,
                onButtonClick = { onBackClick() },
                title = "Registro"
            )
        }
    ) {

        RegisterContent(
            paddingValues = it,
            state = state,
            onEvent = { event ->
                viewModel.onEvent(event)
            },
        )

    }

}