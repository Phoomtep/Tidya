package com.example.tidya

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.tidya.model.AuthViewModel
import com.example.tidya.presentation.AuthScreen
import com.example.tidya.ui.theme.TidyaTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi
import dagger.hilt.android.AndroidEntryPoint

var outfit = FontFamily(
    listOf(
        Font(R.font.outfit_regular, FontWeight.Normal),
        Font(R.font.outfit_bold, FontWeight.Bold)
    )
)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalCoroutinesApi
    @ExperimentalFoundationApi
    @ExperimentalAnimationApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TidyaTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    AuthScreen(AuthViewModel())
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TidyaTheme {

    }
}