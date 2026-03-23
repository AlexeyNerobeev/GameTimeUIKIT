package com.example.uikit.Buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.Theme

//23.03.2026
//Алексей
@Preview(showBackground = true)
@Composable
fun prevSecondaryButton(){
    SecondaryButton(
        text = "text"
    ) { }
}

//метод для отображения 2 варианта кнопки. Принимет модификатор, иконку, текст кнопки, метод клика по кнопке
@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    icon: Int? = null,
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .heightIn(30.dp)
            .widthIn(200.dp)
            .shadow(elevation = 3.dp,
                spotColor = Color(0xFF8A9BBD).copy(alpha = 0.48f),
                shape = RoundedCornerShape(30.dp))
            .clip(RoundedCornerShape(60.dp))
            .background(brush = Brush.horizontalGradient(colors = listOf(
                Color(0xFFE9F0F7),
                Color(0xFFFFFFFF)
            )))
            .border(1.dp, brush = Brush.horizontalGradient(colors = listOf(
                Color(0xFFFFFFFF).copy(alpha = 0.3f),
                Color(0xFFD6E5F2)
            )),
                shape = RoundedCornerShape(30.dp)),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color(0xFF8F9BB2)
        )
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (icon != null){
                Icon(painter = painterResource(icon),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .padding(end = 4.dp))
            }
            Text(text = text,
                style = Theme.typography.caption2Bold)
        }
    }
}