package com.example.uikit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//23.03.2026
//Алексей
@Preview
@Composable
fun prevCard(){
    Card(
        title = "Schedule",
        text = "Easily schedule event/games\n" +
                "then find like minded players for battle. You up for it?",
        onCLick = {},
        image = R.drawable.test_image
    )
}

//метод для отображения карточки. Принимает заголовок, основной текст, метод клика по карточке,
//картинку и модификатор
@Composable
fun Card(
    title: String,
    text: String,
    onCLick: () -> Unit,
    image: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(169.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFF6480),
                        Color(0xFFF22E63)
                    )
                ),
                shape = RoundedCornerShape(10.dp)
            )
            .clickable{
                onCLick()
            }
    ){
        Box(modifier = Modifier
            .padding(top = 30.dp)
            .padding(start = 24.dp)
            .padding(end = 22.dp)
            .padding(bottom = 19.dp)
            .fillMaxWidth()) {
            Image(painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .width(120.dp),
                contentScale = ContentScale.FillWidth)
            Column(modifier = Modifier
                .align(Alignment.TopStart)
                .fillMaxWidth(0.6f)) {
                Text(text = title,
                    style = Theme.typography.caption2Bold,
                    color = White)
                Text(text = text,
                    style = Theme.typography.caption2Regular,
                    color = White,
                    modifier = Modifier
                        .padding(top = 14.dp),
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis)
                Icon(painter = painterResource(R.drawable.forward_arrow),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .padding(top = 42.dp))
            }
        }
    }
}