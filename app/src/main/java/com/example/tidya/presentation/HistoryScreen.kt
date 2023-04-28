package com.example.tidya.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tidya.model.User
import com.example.tidya.outfit

@Composable
fun HistoryScreen(user: User){
    Scaffold {innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {
            Text(
                text = "History", modifier = Modifier.padding(top = 20.dp, start = 20.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontFamily = outfit
            )

        }
    }
}