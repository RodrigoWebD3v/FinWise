package com.example.finwise.views.sharedComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finwise.R
import com.example.finwise.ui.theme.Light_Green
import com.example.finwise.ui.theme.TextGreen


@Composable
fun InputTextPassword(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit
) {
    var isPasswordVisible by remember { mutableStateOf(false) }

    var keyboardType by remember { mutableStateOf(KeyboardType.Password) }

    var visualTransformation by remember { mutableStateOf(VisualTransformation.None) }

    LaunchedEffect(isPasswordVisible) {
        if (!isPasswordVisible) {
            keyboardType = KeyboardType.Password
            visualTransformation = PasswordVisualTransformation()
        } else {
            keyboardType = KeyboardType.Text
            visualTransformation = VisualTransformation.None
        }
    }

    Column {
        Text(
            label,
            style = TextStyle(
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                fontWeight = FontWeight(500),
                color = TextGreen,
            ),
            modifier = Modifier.padding(start = 20.dp)
        )
        TextField(
            value = value,
            onValueChange = { novoValor ->
                onValueChange(novoValor)
            },
            placeholder = { Text(placeholder) },
            shape = RoundedCornerShape(30.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Light_Green,
                focusedContainerColor = Light_Green,
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),

            trailingIcon = {
                Icon(
                    imageVector = if (!isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                    contentDescription = stringResource(R.string.togglepasswordvisibility),
                    tint = Color.Gray,
                    modifier = Modifier.clickable {
                        isPasswordVisible = !isPasswordVisible
                    }
                )
            },

            textStyle = TextStyle(color = Color.Black),
            visualTransformation = visualTransformation,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth(0.8f)
        )
    }

}

//@Preview
//@Composable
//private fun InputTextPrev() {
//    InputTextPassword(
//        valueOne = "Teste", valueTwo = "123"
//    )
//}