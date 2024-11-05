package com.carlostorres.ecommerce.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.carlostorres.ecommerce.ui.theme.Blue500

@Composable
fun DefaultButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    onClick: () -> Unit,
    color: Color = Blue500,
    icon: ImageVector? = null
) {

    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(5.dp),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 10.dp),
        onClick = { onClick() }
    ) {
        if (icon != null) {
            Icon(
                modifier = Modifier.padding(end = 10.dp),
                imageVector = icon,
                contentDescription = ""
            )
        }
        Text(text = buttonText)
    }

}