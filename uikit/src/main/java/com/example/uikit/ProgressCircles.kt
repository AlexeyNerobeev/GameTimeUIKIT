package com.example.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//23.03.2026
//Алексей
@Preview
@Composable
fun prevProgressCircles(){
    ProgressCircles(
        1
    )
}

//метод для отображения ProgressCircles. Принимает модификатор и текущую позицию маркера
@Composable
fun ProgressCircles(
    currentNumber: Int,
    modifier: Modifier = Modifier
) {
    val circlesList = listOf(
        1,
        2,
        3
    )
    Row(modifier = modifier) {
        circlesList.forEach {
            Box(
                modifier = Modifier
                    .background(
                        color = if (it == currentNumber) {
                            Color(0xFFFA5075)
                        } else{
                            InputIcon
                        },
                        shape = CircleShape
                    )
                    .size(10.dp)
            )
            Spacer(modifier = Modifier
                .width(10.dp))
        }
    }
}