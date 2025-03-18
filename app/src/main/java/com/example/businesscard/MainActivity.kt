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
        Row(Modifier.weight(3f)) {
            BusinessCardInfo(
                imagePainter = painterResource(R.drawable.mkphoto),
                name = stringResource(R.string.name),
                title = stringResource(R.string.title),
                backgroundColor = Color(0xDBFFE374),
                modifier = Modifier.weight(1f),
            )
        }
        Row(Modifier.weight(1f)) {
            BusinessCardContact(
                phoneIcon = painterResource(R.drawable.baseline_phone_24),
                phoneNumber = stringResource(R.string.phone_number),
                emailIcon = painterResource(R.drawable.baseline_alternate_email_24),
                email = stringResource(R.string.email),
                flagIcon = painterResource(R.drawable.baseline_flag_24),
                location = stringResource(R.string.location),
                backgroundColor = Color(0xDBFFE374),
                modifier = Modifier.weight(1f)
            )
        }
    }
}
//removed row and everything is the same
//tried to create another row with attributes separated but that seems like
//i would need to create another private function to call in the public function
//could divide sections to name/title part and contact part
//then those could be separated into rows
//would be cool to add icons, is that res or part of Material?

@Composable
private fun BusinessCardInfo(
    imagePainter: Painter,
    name: String,
    title: String,
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
            modifier = Modifier.padding(top = 30.dp, bottom = 9.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = title,
            fontSize = 15.sp
        )
    }
}

//create contact section
@Composable
private fun BusinessCardContact(
    phoneIcon: Painter,
    emailIcon: Painter,
    flagIcon: Painter,
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
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Image(painter = phoneIcon, contentDescription = null)
            Text(
                text = phoneNumber,
                fontSize = 12.sp
            )
        }
        Row {
            Image(painter = emailIcon, contentDescription = null)
            Text(
                text = email,
                fontSize = 12.sp
            )
        }
        Row {
            Image(painter = flagIcon, contentDescription = null)
            Text(
                text = location,
                fontSize = 12.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}