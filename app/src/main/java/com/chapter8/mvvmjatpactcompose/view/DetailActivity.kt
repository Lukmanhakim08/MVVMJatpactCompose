package com.chapter8.mvvmjatpactcompose.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.chapter8.mvvmjatpactcompose.model.DataFilmResponseItem
import com.chapter8.mvvmjatpactcompose.view.ui.theme.MVVMJatpactComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMJatpactComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val film = intent.getSerializableExtra("DATANEWS") as DataFilmResponseItem
                    DisplayDetail(film)
                }
            }
        }
    }
}

@Composable
fun DisplayDetail(film: DataFilmResponseItem) {
    Column(
        modifier = Modifier
            .padding(15.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Image(
                painter = rememberImagePainter(data = film.image),
                contentDescription = "",
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            )
            Text(
                text = "Title: \n${film.title}",
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Text(
                text = "Author: \n${film.author}",
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Text(
                text = "Created at: \n${film.createdAt}",
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Text(
                text = "Desc: \n${film.description}",
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(bottom = 10.dp),
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview2() {
    MVVMJatpactComposeTheme {
        DisplayDetail(
            film = DataFilmResponseItem(
                "author",
                "when",
                "desc",
                "1",
                "http://placeimg.com/640/480",
                "title"
            )
        )
    }
}