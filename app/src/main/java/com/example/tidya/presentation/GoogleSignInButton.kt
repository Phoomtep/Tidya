package com.example.tidya.presentation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.tidya.R
import com.example.tidya.outfit

@ExperimentalMaterialApi
@Composable
fun GoogleSignInButtonUi(
    onClicked:() -> Unit){

    var clicked by remember { mutableStateOf(false)}

    Surface(
        onClick = {clicked = !clicked},
        shape = RoundedCornerShape(40.dp),
        modifier = Modifier.padding(start = 40.dp, end = 40.dp, top = 340.dp)
            .fillMaxWidth()
    ) {
        Row (modifier = Modifier
            .padding(
                start = 12.dp,
                end = 16.dp,
                top = 12.dp,
                bottom = 12.dp
            )
            ,verticalAlignment = Alignment.CenterVertically,horizontalArrangement = Arrangement.Center){
            Icon(painter = painterResource(id = R.drawable.ic_google_icon), contentDescription = "Google sign button", tint = Color.Unspecified)
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "CONTINUE WITH GOOGLE", fontFamily = outfit)

            if (clicked){
                onClicked()
            }

        }
    }



}

@ExperimentalMaterialApi
@Composable
@Preview
fun GoogleButtonPreview(){
    GoogleSignInButtonUi(
        onClicked = {}
    )
}