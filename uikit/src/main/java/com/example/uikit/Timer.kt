package com.example.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//23.03.2026
//Алексей
@Preview
@Composable
fun prevTimer(){
    Timer()
}

//метод для отображения таймера. Принимает модификатор, минуты и секунды
@Composable
fun Timer(
    modifier: Modifier = Modifier,
    minutes: Int = 0,
    seconds: Int = 0
) {
    Box(
        modifier = modifier
            .heightIn(100.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFF6480),
                        Color(0xFFF22E63)
                    )
                )
            )
    ) {
        Column(modifier = Modifier
            .padding(top = 7.dp)
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Timer",
                style = Theme.typography.caption2Regular,
                color = White)
            Row(modifier = Modifier
                .padding(top = 14.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Text(text = if(minutes<10){
                    "0$minutes:"
                } else{
                    "$minutes:"
                },
                    style = Theme.typography.title1Extrabold,
                    color = White)
                Text(text = if(seconds < 10){
                    "0$seconds"
                } else{
                    seconds.toString()
                },
                    style = Theme.typography.title1Extrabold,
                    color = White)
            }
        }
    }
}