package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier =  Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(Modifier.fillMaxSize()) {
        Row(Modifier.weight(1f)) {
            BusinessCardInfo(
                imagePainter = painterResource(R.drawable.mkphoto),
                name = stringResource(R.string.name),
                title = stringResource(R.string.title),
                phoneNumber = stringResource(R.string.phone_number),
                email = stringResource(R.string.email),
                location = stringResource(R.string.location),
                backgroundColor = Color(0xDBFFE374),
                modifier = Modifier.weight(1f),
            )
        }
    }
}
//BusinessCard function
//1 column with 2 rows
//row1: image:painter, name:string, title:string
//row2: phone number:int, email:string, location:string
//maybe multiple rows, 2-4 for phone, email, location?
//center align content vertically on screen(or each row?)

@Composable
private fun BusinessCardInfo(
    imagePainter: Painter,
    name: String,
    title: String,
    phoneNumber: String,
    email: String,
    location: String,
    backgroundColor: Color,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = imagePainter, contentDescription = null)
        Text(
            text = name,
            modifier = Modifier.padding(top = 24.dp, bottom = 9.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = title,
            fontSize = 15.sp
        )
        Text(
            text = phoneNumber,
            fontSize = 12.sp
        )
        Text(
            text = email,
            fontSize = 12.sp
        )
        Text(
            text = location,
            fontSize = 12.sp
        )
    }
}
//private BusinessCardInfo function
//alignment:center
//arrangement:center
//name font:bold, title font: default

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}