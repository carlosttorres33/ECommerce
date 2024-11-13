package com.carlostorres.ecommerce.auth.ui.login.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.carlostorres.ecommerce.R
import com.carlostorres.ecommerce.auth.presentation.login.LoginEvents
import com.carlostorres.ecommerce.auth.presentation.login.LoginState
import com.carlostorres.ecommerce.ui.components.DefaultButton
import com.carlostorres.ecommerce.ui.components.DefaultTextField
import com.carlostorres.ecommerce.ui.components.PasswordTextField
import com.carlostorres.ecommerce.ui.theme.Blue700

@Composable
fun LoginContent(
    paddingValues: PaddingValues,
    state: LoginState,
    onEvent: (LoginEvents) -> Unit,
    navigateToRegister: () -> Unit
) {

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {

        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Bkg Image",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(
                ColorMatrix().apply {
                    setToScale(0.5f, 0.5f, 0.5f, 1f)
                }
            )
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                modifier = Modifier.size(100.dp),
                painter = painterResource(id = R.drawable.shopping_cart_blue),
                contentDescription = "Logo"
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "E-Commerce App",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(
                    topStart = 40.dp,
                    topEnd = 40.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 0.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.7f)
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        modifier = Modifier
                            .padding(bottom = 20.dp),
                        text = "Ingresar",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black
                    )

                    DefaultTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = state.email,
                        onValueChange = {
                            onEvent(LoginEvents.OnEmailChange(it))
                        },
                        labelText = "Correo Electrónico",
                        icon = Icons.Filled.Email,
                        keyboardType = KeyboardType.Email
                    )

                    PasswordTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = state.password,
                        onValueChange = {
                            onEvent(LoginEvents.OnPasswordChange(it))
                        },
                        labelText = "Contraseña",
                        icon = Icons.Filled.Lock,
                        keyboardType = KeyboardType.Password
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    AnimatedVisibility(visible = state.formErrorMsg != null) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .animateContentSize(),
                            text = state.formErrorMsg ?: "",
                            color = Color.Red,
                            textAlign = TextAlign.Center
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    DefaultButton(
                        modifier = Modifier.fillMaxWidth(),
                        buttonText = "Iniciar Sesion",
                        icon = Icons.AutoMirrored.Filled.ArrowForward,
                        onClick = {
                            onEvent(LoginEvents.IsValidForm)
                        }
                    )

                    Row(
                        modifier = Modifier
                            .padding(top = 10.dp)
                    ) {
                        Text(text = "No tienes cuenta?")
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            modifier = Modifier.clickable {
                                navigateToRegister()
                            },
                            text = "Registrate",
                            color = Blue700,
                            fontWeight = FontWeight.Bold
                        )
                    }

                }

            }

        }
    }
}