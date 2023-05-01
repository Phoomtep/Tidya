package com.example.tidya.presentation

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.widget.DatePicker
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tidya.R
import com.example.tidya.bottomnav.BottomBarScreen
import com.example.tidya.database.DrugViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tidya.database.GetDrug
import java.time.LocalDate


@Composable

fun AddScreen(navController: NavController,drugViewModel: DrugViewModel = hiltViewModel()) {

    val drugs = drugViewModel.drugs.collectAsState(initial = emptyList())

    val name = remember {
        mutableStateOf("")
    }

    val date = remember {
        mutableStateOf("")
    }
    val dateVal = date.value


    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    val selectedyear = calendar[Calendar.YEAR]
    val selectedmonth = calendar[Calendar.MONTH]
    val dayOfMonth = calendar[Calendar.DAY_OF_MONTH]
    val selectedDate = remember { mutableStateOf(LocalDate.now()) }

    val yearEvent = calendar[Calendar.YEAR]
    val monthEvent = calendar[Calendar.MONTH]
    val dayOfMonthEvent = calendar[Calendar.DAY_OF_MONTH]
    val selectedDateEvent = remember { mutableStateOf(LocalDate.now()) }

    val selectedHour = calendar[Calendar.HOUR_OF_DAY]
    val selectedMinute = calendar[Calendar.MINUTE]
    val selectedTime = remember { mutableStateOf("") }
    val selectHour = remember { mutableStateOf("") }


    val formatDate1 = selectedDate.value.format(formatter)
    val formatDate2 = selectedDateEvent.value.format(formatter)

    val dateToday = DatePickerDialog(
        context,
        { _: DatePicker, selectedyear: Int, selectedmonth: Int, selectedDayOfMonth: Int ->
            selectedDate.value = LocalDate.of(selectedyear, selectedmonth + 1, selectedDayOfMonth)
        }, selectedyear, selectedmonth, dayOfMonth
    )
    val dateEvent = DatePickerDialog(
        context,
        { _: DatePicker, yearEvent: Int, monthEvent: Int, selectDayOfMonth: Int ->
            selectedDateEvent.value = LocalDate.of(yearEvent, monthEvent + 1, selectDayOfMonth)
        }, yearEvent, monthEvent, dayOfMonthEvent
    )
    val timePicke = TimePickerDialog(
        context,
        { _, selectedHour: Int, selectedMinute: Int ->
            selectedTime.value = "$selectedHour:$selectedMinute"
            selectHour.value = "$selectedHour"
        }, selectedHour, selectedMinute, true
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp, start = 20.dp)
    )
    {
        Button(onClick = { navController.navigate(BottomBarScreen.Home.route) },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = null
            )
            Text(text = "Add")
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, top = 100.dp, bottom = 100.dp)
            .verticalScroll(rememberScrollState())
            .background(
                Color(0xffEBEBEB),
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        Text(text = "Generic name or Display name", Modifier.padding(top = 20.dp, start = 20.dp), fontWeight = FontWeight.Bold)
        var text by remember { mutableStateOf("") }
        OutlinedTextField(
            value = name.value, onValueChange = { name.value = it }
            //label = { Text(text = "Enter Drug Name") },
            //onValueChange = {
            //text = it
            //},
            , modifier = Modifier.padding(start = 20.dp)
        )
        Text(text = "Reminder", Modifier.padding(top = 20.dp, start = 20.dp), fontWeight = FontWeight.Bold)

//        Row(modifier = Modifier
//            .fillMaxSize()
//        ) {
//            Button(onClick = {
//                dateToday.show()
//            },Modifier.padding(start = 20.dp),
//                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffEBEBEB))
//            ) {
//                Icon(painter = painterResource(id = R.drawable.ic_calendar_today), contentDescription = null)
//            }
//            Text(text = "${formatDate1}",Modifier.padding(top = 15.dp,start = 10.dp),fontSize = 14.sp)
//
//            Text(text = "To",Modifier.padding(top = 12.dp,start = 5.dp))
//
//            Button(onClick = {
//                dateEvent.show()
//            },Modifier.padding(start = 10.dp),
//                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffEBEBEB))
//            ) {
//                Icon(painter = painterResource(id = R.drawable.ic_calendar_event), contentDescription = null)
//            }
//            Text(text = "${formatDate2}",Modifier.padding(top = 15.dp,start = 10.dp),fontSize = 14.sp)
//        }

        Column() {
            Row() {
                Button(
                    onClick = {
                        dateToday.show()
                    }, Modifier.padding(start = 20.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffEBEBEB))
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_calendar_today),
                        contentDescription = null
                    )
                }
                Text(
                    text = "${formatDate1}",
                    Modifier.padding(top = 15.dp, start = 20.dp),
                    fontSize = 14.sp
                )
            }

//            Text(text = "To", Modifier.padding(top = 5.dp, end = 15.dp, start = 20.dp), fontSize = 15.sp, color = Color(0xff7D7D7D))
//
//            Row(modifier = Modifier.padding(end = 20.dp)) {
//                Button(
//                    onClick = {
//                        dateEvent.show()
//                    }, Modifier.padding(start = 20.dp),
//                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffEBEBEB))
//                ) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.ic_calendar_event),
//                        contentDescription = null
//                    )
//                }
//                Text(
//                    text = "${formatDate2}",
//                    Modifier.padding(top = 15.dp, start = 20.dp),
//                    fontSize = 14.sp
//                )
//            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp)
        ) {

            Text(text = "Set time", Modifier.padding(end = 20.dp, start = 20.dp), fontWeight = FontWeight.Bold)

            Row() {
                Button(
                    onClick = {
                        timePicke.show()
                    }, Modifier.padding(start = 20.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffEBEBEB))
                ) {
                    Icon(painter = painterResource(id = R.drawable.ic_alarm), contentDescription = null)
                }
                Text(text = "${selectedTime.value}", Modifier.padding(top = 15.dp, start = 10.dp))
                val htime = "${selectHour.value}"
                if (htime == "0" || htime == "1" || htime == "2" || htime == "3" ||
                    htime == "4" || htime == "5" || htime == "6" || htime == "7" ||
                    htime == "8" || htime == "9" || htime == "10" || htime == "11"
                ) {
                    Text(text = "AM", Modifier.padding(top = 15.dp, start = 10.dp))
                } else {
                    Text(text = " PM", Modifier.padding(top = 15.dp, start = 10.dp))
                }
            }
        }

        Column(
            Modifier
                .fillMaxSize()
                .padding(top = 140.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Button(
                onClick = {
                    drugViewModel.insertDrug(
                        GetDrug(
                            name = name.value,
                            time = "${selectedTime.value}",
                            date = "${formatDate1}",
                        )
                    ); navController.navigate(BottomBarScreen.Home.route)
                }, Modifier.size(50.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff16C2D5)),
                contentPadding = PaddingValues(0.dp)
            ) {
                Icon(Icons.Default.Add, contentDescription = null, tint = Color.White)
            }
        }


    }
}