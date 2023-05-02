package com.example.tidya.presentation

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.util.Log
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tidya.database.DrugViewModel
import com.example.tidya.model.User
import com.example.tidya.outfit
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.annotation.meta.When


val formatter = DateTimeFormatter.ofPattern("d MMM yyyy")

@Composable
fun HistoryScreen(user: User,drugViewModel: DrugViewModel = hiltViewModel()){

    val drugs = drugViewModel.drugs.collectAsState(initial = emptyList())

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

            LazyColumn(modifier = Modifier.padding(bottom = 60.dp)) {
                items(drugs.value) { drugs ->
                    println(drugs.date)
                    println("${formatDate}")
                    when (drugs.date) {
                        "${formatDate}" -> Row(
                            modifier = Modifier.clip(RoundedCornerShape(60f))
                                .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                        ) {
                            Drug(drugs.id, drugs.name, drugs.time, drugs.Status)
                        }
                    }
                }

            }

        }
    }
}
