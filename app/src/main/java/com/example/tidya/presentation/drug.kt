package com.example.tidya.presentation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tidya.R
import com.example.tidya.database.DrugViewModel
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

//name: String, time: String, isComplete: Boolean
@Composable
fun Drug(id : Int ,name: String, time: String, isComplete: Boolean,drugViewModel: DrugViewModel = hiltViewModel()) {

    val swipeDelete = SwipeAction(
        onSwipe = {
            drugViewModel.deleteData(id)
            Log.d("$id","Delete")
            //ลบตรงนี้


        },
        icon = {
            Icon(
                modifier = Modifier.padding(16.dp),
                painter = painterResource(id = R.drawable.baseline_delete_24), contentDescription = null, tint = Color.Unspecified)
        },
        background = Color.Red
    )

    val drugs = drugViewModel.drugs.collectAsState(initial = emptyList())
    var status by remember { mutableStateOf(isComplete) }
    var textcolor = when (status){
        true -> Color(0xff7D7D7D)
        false -> Color(0xff000000)
    }

    Row(modifier = Modifier.clip(RoundedCornerShape(60f))
    ){SwipeableActionsBox(swipeThreshold = 50.dp,endActions = listOf(swipeDelete)) {
        Row(modifier = Modifier
            .fillMaxWidth()
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
                    , fontSize = 15.sp
                    , color = textcolor)
                Text(text = time, Modifier
                    .padding(top = 2.dp, start = 20.dp)
                    , fontWeight = FontWeight.Bold
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
                    //, onClick = {drugViewModel.updateStatus(id = 8)}){
                    , onClick = { status = !status ;
                        when (status){
                            true -> drugViewModel.updateStatusTrue(id = id)
                            false -> drugViewModel.updateStatusFalse(id = id)} }) { //เขียน Update Database ตรงนี้ !!!!!!
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
    }}
}
