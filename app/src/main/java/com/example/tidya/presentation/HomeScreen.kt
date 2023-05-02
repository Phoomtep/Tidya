package com.example.tidya.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tidya.R
import com.example.tidya.bottomnav.BottomBarScreen
import com.example.tidya.database.DrugViewModel
import com.example.tidya.model.User
import com.example.tidya.outfit
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(user: User, navController: NavController,drugViewModel: DrugViewModel = hiltViewModel()) {  //HomeScreen(user: User)

    val currentDateTime = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("d MMM yyyy")
    val today = currentDateTime.format(formatter)


    val drugs = drugViewModel.drugs.collectAsState(initial = emptyList())

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Text(
                text = "Home",
                modifier = Modifier.padding(top = 20.dp, start = 20.dp, bottom = 20.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontFamily = outfit
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp)
                    .height(150.dp)
                    .background(
                        Color(0xff16C2D5),
                        shape = RoundedCornerShape(20.dp)
                    )
            ) {
                Row() {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_face_24),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.padding(start = 20.dp, top = 20.dp)
                    )
                    Text(
                        text = "${user.displayName}",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h4,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(start = 20.dp, top = 25.dp)
                    )
                }
                Text(
                    text = "${user.email}",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h4,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(start = 80.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ) {
                Text(
                    text = "Today activityes", modifier = Modifier
                        .padding(start = 20.dp, top = 15.dp), fontWeight = FontWeight.Bold
                )

                IconButton(modifier = Modifier.padding(start = 180.dp), onClick = {
                    navController.navigate(
                        BottomBarScreen.Add.route
                    )
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_add_24),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                }
            }

            LazyColumn(modifier = Modifier.padding(bottom = 60.dp)) {
                items(drugs.value) { drugs ->
                    when (drugs.date){
                        "${today}" -> Row(modifier = Modifier.clip(RoundedCornerShape(60f))
                            .padding(start = 20.dp, end = 20.dp, top=20.dp)) {
                            Drug(drugs.id, drugs.name, drugs.time, drugs.Status)
                        }
                    }

                }

            }
        }
    }

}