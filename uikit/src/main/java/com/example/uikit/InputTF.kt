package com.example.uikit

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//23.03.2026
//Алексей
@Preview
@Composable
fun prevInput(){
    val value = remember { mutableStateOf("") }
    InputTF(
        value = value.value,
        onValueChange = {
            value.value = it
        },
        placeholder = "Full Name"
    )
}

//метод для отображения инпута. Принимает модификатор, значение инпута, метод для изменения значения,
//плейсхолдер, есть ли иконка пароля
@Composable
fun InputTF(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    withTrailingIcon: Boolean = false
) {
    val visualTransformation = remember { mutableStateOf(true) }
    TextField(
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            focusedTextColor = Black,
            unfocusedTextColor = Black,
            focusedPlaceholderColor = Black,
            unfocusedPlaceholderColor = Black,
            focusedIndicatorColor = Color(0xFFFF6480),
            unfocusedIndicatorColor = Color(0xFFFF6480),
            focusedTrailingIconColor = Black,
            unfocusedTrailingIconColor = Black,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent
        ),
        visualTransformation = if(withTrailingIcon){
            if(visualTransformation.value){
                PasswordVisualTransformation()
            } else{
                VisualTransformation.None
            }
        } else{
            VisualTransformation.None
        },
        trailingIcon = {
            if(withTrailingIcon) {
                IconButton(
                    onClick = {
                        visualTransformation.value = !visualTransformation.value
                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.invisible_icon),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                }
            }
        },
        placeholder = {
            Text(text = placeholder,
                style = Theme.typography.caption2Regular,
                color = Black,
                modifier = Modifier
                    .padding(start = 0.dp))
        },
        singleLine = true
    )
}