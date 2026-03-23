package com.example.uikit.Buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.Theme
import com.example.uikit.White

//23.03.2026
//Алексей
@Preview
@Composable
fun prevMainButton(){
    MainButton(
        text = "text"
    ) { }
}

//метод для отображения главной кнопки. Принимает модификатор, текст кнопки, метод клика по кнопке
@Composable
fun MainButton(
    modifier: Modifier = Modifier,
    text: String,
    onCLick: () -> Unit
) {
    Button(
        onClick = onCLick,
        modifier = modifier
            .height(58.dp)
            .widthIn(210.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFF6480),
                        Color(0xFFF22E63)
                    )
                )
            ),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Color.Transparent
        )
    ) {
        Text(
            text = text,
            style = Theme.typography.title3Semibold
        )
    }
}