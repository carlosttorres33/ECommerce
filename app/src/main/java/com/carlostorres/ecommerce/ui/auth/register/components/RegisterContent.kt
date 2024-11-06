package com.carlostorres.ecommerce.ui.auth.register.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.carlostorres.ecommerce.R
import com.carlostorres.ecommerce.ui.auth.login.components.LoginContent
import com.carlostorres.ecommerce.ui.components.DefaultButton
import com.carlostorres.ecommerce.ui.components.DefaultTextField
import com.carlostorres.ecommerce.ui.components.PasswordTextField

@Composable
fun RegisterContent(
    paddingValues: PaddingValues,
) {

    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
    ){

        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(id = R.drawable.banner),
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

            Image(
                modifier = Modifier.size(100.dp),
                painter = painterResource(id = R.drawable.user_image),
                contentDescription = ""
            )

            Spacer(modifier = Modifier.height(10.dp))
            
            Text(
                text = "Ingresa Tu Info",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White
            )

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
                        value = "",
                        onValueChange = {},
                        labelText = "Nombres",
                        icon = Icons.Filled.Person
                    )

                    DefaultTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        labelText = "Apellidos",
                        icon = Icons.Outlined.Person
                    )

                    DefaultTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        labelText = "Teléfono",
                        icon = Icons.Filled.Phone,
                        keyboardType = KeyboardType.Phone
                    )

                    DefaultTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        labelText = "Correo Electrónico",
                        icon = Icons.Filled.Email,
                        keyboardType = KeyboardType.Email
                    )

                    PasswordTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        labelText = "Contraseña",
                        icon = Icons.Filled.Lock,
                        keyboardType = KeyboardType.Password
                    )

                    PasswordTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        labelText = "Confirmar Contraseña",
                        icon = Icons.Filled.Lock,
                        keyboardType = KeyboardType.Password
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    DefaultButton(
                        modifier = Modifier
                            .fillMaxWidth(),
                        buttonText = "Confirmar",
                        onClick = {  }
                    )

                }

            }

        }

    }

}

@Preview
@Composable
private fun PLC() {
    RegisterContent(paddingValues = PaddingValues())
}