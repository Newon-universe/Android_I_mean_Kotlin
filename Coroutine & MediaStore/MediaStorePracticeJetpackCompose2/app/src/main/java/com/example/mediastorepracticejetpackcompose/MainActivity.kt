package com.example.mediastorepracticejetpackcompose

import MainActivityViewModel
import android.app.Application
import android.content.ContentResolver
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.CalendarContract.Attendees.query
import android.provider.CalendarContract.EventDays.query
import android.provider.CalendarContract.Instances.query
import android.provider.CalendarContract.Reminders.query
import android.provider.MediaStore.Images.Media.query
import android.provider.MediaStore.Video.query
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContentResolverCompat.query
import com.example.mediastorepracticejetpackcompose.ui.theme.MediaStorePracticeJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MediaStorePracticeJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    val data = MainActivityViewModel(Application())
    val imageList = data.images.value!!


    LazyColumn{
        items(imageList){ data ->
            Image(painter = painterResource(id = data.id.toInt()), contentDescription = "")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MediaStorePracticeJetpackComposeTheme {
        Greeting("Android")
    }
}