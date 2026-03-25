package com.example.uikit

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun prevBottomBar(){
    BottomBar(
        1,
        onStatisticsClick = {  },
        onDiscoverClick = {  },
        onChatClick = {},
        onProfileClick = {  },
        onCalendarClick = {  }
    )
}

//метод для отображения нижней навигации. Принимает номер текущего скрина, методы для нажатия на каждую кнопку
// и модификатор
@Composable
fun BottomBar(
    currentScreen: Int,
    onStatisticsClick: () -> Unit,
    onDiscoverClick: () -> Unit,
    onChatClick: () -> Unit,
    onProfileClick: () -> Unit,
    onCalendarClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(110.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.container_bottombar),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(110.dp)
        )
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 15.dp)
                .size(56.dp)
                .border(
                    5.dp, color = White,
                    shape = CircleShape
                )
                .clickable {
                    onCalendarClick()
                },
            contentAlignment = Alignment.Center
        ){
            Icon(painter = painterResource(R.drawable.calendar_icon),
                contentDescription = null,
                tint = Color.Unspecified)
        }
        Row(modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(horizontal = 20.dp)
            .padding(bottom = 29.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically){
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .clickable{
                            if(currentScreen != 1) {
                                onStatisticsClick()
                            }
                        }) {
                    Icon(painter = painterResource(R.drawable.statistics_icon),
                        contentDescription = null,
                        tint = White)
                    Text(text = "Statistics",
                        style = Theme.typography.caption2Regular,
                        color = White)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(start = 26.dp)
                        .clickable {
                            if (currentScreen != 2)
                                onDiscoverClick()
                        }) {
                    Icon(painter = painterResource(R.drawable.discover_icon),
                        contentDescription = null,
                        tint = White)
                    Text(text = "Discover",
                        style = Theme.typography.caption2Regular,
                        color = White)
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .clickable{
                            if(currentScreen != 3)
                            onChatClick()
                        }) {
                    Icon(painter = painterResource(R.drawable.chat_icon),
                        contentDescription = null,
                        tint = White)
                    Text(text = "Chat",
                        style = Theme.typography.caption2Regular,
                        color = White)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(start = 38.dp)
                        .clickable {
                            if (currentScreen != 4)
                                onProfileClick()
                        }) {
                    Icon(painter = painterResource(R.drawable.profile_icon),
                        contentDescription = null,
                        tint = White)
                    Text(text = "Profile",
                        style = Theme.typography.caption2Regular,
                        color = White)
                }
            }
        }
    }
}