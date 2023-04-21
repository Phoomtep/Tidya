package com.example.tidya.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tidya.R
import com.example.tidya.bottomnav.BottomBarScreen
import com.example.tidya.model.User
import com.example.tidya.outfit
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(user: User, navController: NavController){  //HomeScreen(user: User)
    val currentDate = LocalDate.now()
    Scaffold {innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {
            Text(
                text = "Home", modifier = Modifier.padding(top = 20.dp, start = 20.dp, bottom = 20.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontFamily = outfit
            )
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
                .height(150.dp)
                .background(
                    Color(0xff16C2D5),
                    shape = RoundedCornerShape(20.dp)
                )) {
                Row() {
                    Icon(painter = painterResource(id = R.drawable.baseline_face_24),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.padding(start = 20.dp, top = 20.dp))
                    Text(text = "${user.displayName}",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h4,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(start = 20.dp, top = 25.dp))
                }
                Text(text = "${user.email}",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h4,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(start = 80.dp))
            }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)) {
            Text(text = "Today activityes", modifier = Modifier
                .padding(start = 20.dp, top = 15.dp),fontWeight = FontWeight.Bold)

            IconButton(modifier = Modifier.padding(start = 180.dp), onClick = {navController.navigate(
                BottomBarScreen.Add.route)}) {
                Icon(painter = painterResource(id = R.drawable.baseline_add_24),
                    contentDescription = null,
                    tint = Color.Unspecified)
                }
            }
            
            Text(text = "\"Today's date is $currentDate\"") //currentDate วันทีปัจจุบัน

            for (i in 1..3){ //(Data ทั้งหมดที่จะแสดง Select มาแล้ว)
                //ตัวแสดงยาจาฐานข้อมูล
            }

        }
    }
}
