package com.example.tidya.presentation

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tidya.model.User
import com.example.tidya.outfit
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

val currentDateTime = LocalDateTime.now()
val formatter = DateTimeFormatter.ofPattern("d MMM yyyy")
val formattedDate = currentDateTime.format(formatter)

@Composable
fun HistoryScreen(user: User){

    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    val selectedyear = calendar[Calendar.YEAR]
    val selectedmonth = calendar[Calendar.MONTH]
    val dayOfMonth = calendar[Calendar.DAY_OF_MONTH]
    val selectedDate = remember { mutableStateOf(LocalDate.now()) }
    val formatDate = selectedDate.value.format(formatter)

    val dateToday = DatePickerDialog(
        context,
        { _: DatePicker, selectedyear: Int, selectedmonth: Int, selectedDayOfMonth: Int ->
            selectedDate.value = LocalDate.of(selectedyear, selectedmonth + 1, selectedDayOfMonth)
        }, selectedyear, selectedmonth, dayOfMonth
    )

    Scaffold {innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {
            Text(
                text = "History", modifier = Modifier.padding(top = 20.dp, start = 20.dp, bottom = 40.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontFamily = outfit
            )

            Text(text = "${formatDate}", modifier = Modifier
                .clickable { dateToday.show() }
                .fillMaxWidth()
                ,textAlign = TextAlign.Center
                ,fontWeight = FontWeight.Normal
                ,fontSize = 18.sp
                ,fontFamily = outfit

            )

            Column(modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(bottom = 60.dp)) {

                Drug("Drug", "11:00", true)
                Drug("Drug2", "12:00", false)

            }
        }
    }
}