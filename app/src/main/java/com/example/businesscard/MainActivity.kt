package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
                    //call BusinessCard()
                }
            }
        }
    }
}

@Composable
//BusinessCard function
//1 column with 2 rows
//row1: image:painter, name:string, title:string
//row2: phone number:int, email:string, location:string

//private BusinessCardInfo function
//alignment:center
//arrangement:center
//name font:bold, title font: default

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        //call BusinessCard()
    }
}