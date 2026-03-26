package com.example.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
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
fun prevInput() {
    val value = remember { mutableStateOf("") }
    InputTF(
        value = value.value,
        onValueChange = {
            value.value = it
        },
        placeholder = "Full Name",
        modifier = Modifier.padding(horizontal = 20.dp),
        withTrailingIcon = false
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
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        textStyle = TextStyle(
            color = Black
        ),
        visualTransformation = if (withTrailingIcon && visualTransformation.value) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        decorationBox = { innerTextField ->
            Column {
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(modifier = Modifier.weight(1f)) {
                        if (value.isEmpty()) {
                            Text(
                                text = placeholder,
                                style = Theme.typography.caption2Regular,
                                color = Black
                            )
                        }
                        innerTextField()
                    }

                    if (withTrailingIcon) {
                        Icon(
                            painter = painterResource(R.drawable.invisible_icon),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .clickable {
                                    visualTransformation.value = !visualTransformation.value
                                }
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(color = Color(0xFFFA5075))
                )
            }
        }
    )
}