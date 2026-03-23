package com.example.uikit.Buttons

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.uikit.R

//23.03.2026
//Алексей
@Preview
@Composable
fun prevLogoutButton(){
    LogoutButton(onCLick = {})
}

//метод для отображения кнопки выхода. Приниммает модификатор и метод клика
@Composable
fun LogoutButton(
    onCLick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Icon(painter = painterResource(R.drawable.logout_button),
        contentDescription = null,
        tint = Color.Unspecified,
        modifier = modifier
            .clickable{
                onCLick()
            })
}