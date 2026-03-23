package com.example.uikit

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//23.03.2026
//Алексей
@Preview(showBackground = true)
@Composable
fun prevCustomCheckBox(){
    val value = remember { mutableStateOf(true) }
    CustomCheckBox(
        value = value.value
    ) {
        value.value = !value.value
    }
}

//метод для отображения checkbox. Принимает модификатор, значение маркера и метод для изменения состояния маркера
@Composable
fun CustomCheckBox(
    modifier: Modifier = Modifier,
    value: Boolean,
    onValueChange: () -> Unit
) {
    Checkbox(
        checked = value,
        onCheckedChange = {
            onValueChange()
        },
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Transparent,
            uncheckedColor = Color.Transparent,
            checkmarkColor = Color(0xFFFA5075)
        ),
        modifier = modifier
            .border(1.dp,
                color = Color(0xFFFA5075),
                shape = RoundedCornerShape(2.dp)
            )
            .size(14.dp)
    )
}