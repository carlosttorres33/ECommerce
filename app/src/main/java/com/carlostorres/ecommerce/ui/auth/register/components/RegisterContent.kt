package com.carlostorres.ecommerce.ui.auth.register.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Person
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.carlostorres.ecommerce.R
import com.carlostorres.ecommerce.presentation.auth.register.RegisterEvents
import com.carlostorres.ecommerce.presentation.auth.register.RegisterState
import com.carlostorres.ecommerce.ui.components.DefaultButton
import com.carlostorres.ecommerce.ui.components.DefaultTextField
import com.carlostorres.ecommerce.ui.components.PasswordTextField

@Composable
fun RegisterContent(
    paddingValues: PaddingValues,
    state: RegisterState,
    onEvent: (RegisterEvents) -> Unit
) {

    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
    ) {

        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(id = R.drawable.banner_form),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(
                ColorMatrix().apply {
                    setToScale(0.5f, 0.5f, 0.5f, 1f)
                }
            )
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Image(
                    modifier = Modifier.size(100.dp),
                    painter = painterResource(id = R.drawable.user_form),
                    contentDescription = ""
                )

                Text(
                    text = "Ingresa Tu Info",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White
                )

            }

            Spacer(modifier = Modifier.weight(1f))

            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.7f)
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp),
                ) {

                    Text(
                        modifier = Modifier,
                        text = "Registrate",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black,
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    DefaultTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = state.name,
                        onValueChange = {
                            onEvent(RegisterEvents.OnNameChange(it))
                        },
                        labelText = "Nombres",
                        icon = Icons.Filled.Person
                    )

                    DefaultTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = state.lastName,
                        onValueChange = {
                            onEvent(RegisterEvents.OnLastNameChange(it))
                        },
                        labelText = "Apellidos",
                        icon = Icons.Outlined.Person
                    )

                    DefaultTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = state.phone,
                        onValueChange = {
                            onEvent(RegisterEvents.OnPhoneChange(it))
                        },
                        labelText = "Teléfono",
                        icon = Icons.Filled.Phone,
                        keyboardType = KeyboardType.Phone
                    )

                    DefaultTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = state.email,
                        onValueChange = {
                            onEvent(RegisterEvents.OnEmailChange(it))
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
                            onEvent(RegisterEvents.OnPasswordChange(it))
                        },
                        labelText = "Contraseña",
                        icon = Icons.Filled.Lock,
                        keyboardType = KeyboardType.Password
                    )

                    PasswordTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = state.confirmPassword,
                        onValueChange = {
                            onEvent(RegisterEvents.OnConfirmPasswordChange(it))
                        },
                        labelText = "Confirmar Contraseña",
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
                        modifier = Modifier
                            .fillMaxWidth(),
                        buttonText = "Confirmar",
                        onClick = {
                            onEvent(RegisterEvents.ValidateForm)
                        }
                    )

                }

            }

        }

    }

}