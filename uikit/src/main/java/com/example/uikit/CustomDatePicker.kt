package com.example.uikit

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun prevCustomDatePicker(){
    CustomDatePicker(
        title = "FROM",
        value = rememberDatePickerState(),
        date = "MON, NOV 4,2019"
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDatePicker(
    title: String,
    value: DatePickerState,
    date: String,
    modifier: Modifier = Modifier
) {
    val showDatePicker = remember { mutableStateOf(false) }
    Column(modifier = modifier) {
        Text(text = title,
            fontFamily = FontFamily(
                Font(resId = R.font.poppins_regular)
            ),
            fontWeight = FontWeight(400),
            fontSize = 8.sp,
            color = Color(0xFFFA5075))
        Row(modifier = Modifier
            .padding(top = 10.dp)
            .clickable{
                showDatePicker.value = !showDatePicker.value
            },
            verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = value.selectedDateMillis?.let { millis ->
                    Instant.ofEpochMilli(millis)
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate()
                        .format(
                            DateTimeFormatter.ofPattern("EEE, MMM d, yyyy", Locale.ENGLISH)
                        )
                        .uppercase()
                } ?: date,
                style = Theme.typography.caption2Regular,
                color = Black
            )
            Icon(painter = painterResource(R.drawable.dropdown_icon),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .padding(start = 16.dp))
        }
    }
    if(showDatePicker.value){
        Box(modifier = Modifier
            .fillMaxSize(),
            contentAlignment = Alignment.Center) {
            DatePicker(
                state = value
            )
        }
    }
}