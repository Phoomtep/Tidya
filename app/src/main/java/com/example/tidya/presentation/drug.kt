package com.example.tidya.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tidya.R

//name: String, time: String, isComplete: Boolean
@Composable
fun Drug(name: String, time: String, isComplete: Boolean) {
    var status by remember { mutableStateOf(isComplete) }
    var textcolor = when (status){
        true -> Color(0xff7D7D7D)
        false -> Color(0xff000000)
    }
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 20.dp, end = 20.dp, top = 25.dp)
        .height(100.dp)
        .background(
            color = Color(0xffEBEBEB),
            shape = RoundedCornerShape(20.dp)
        )
        , verticalAlignment = Alignment.CenterVertically) {

        Column(modifier = Modifier.fillMaxHeight()
            , verticalArrangement = Arrangement.Center) {
            Text(text = name, Modifier
                .padding(start = 20.dp)
                , fontWeight = FontWeight.Bold
                , color = textcolor)
            Text(text = time, Modifier
                .padding(top = 10.dp, start = 20.dp)
                , fontWeight = FontWeight.Normal
                , fontSize = 10.sp
                , color = textcolor)
        }

        Column(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            , verticalArrangement = Arrangement.Center) {
            IconButton(modifier = Modifier
                .align(Alignment.End)
                .padding(end = 20.dp)
                .background(color = Color(0xffD9D9D9), shape = RoundedCornerShape(5.dp))
                .height(24.dp)
                .width(24.dp)
            , onClick = { status = !status ;println("$name | $status") }) {
            Icon(painter = painterResource(id = R.drawable.baseline_check_24),
                contentDescription = null,
                tint = when (status){
                true -> Color.Unspecified
                false -> Color.Transparent
            }
                )
            }
        }
    }
}
