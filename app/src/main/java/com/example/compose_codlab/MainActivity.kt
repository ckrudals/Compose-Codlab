package com.example.compose_codlab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_codlab.ui.theme.ComposeCodlabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCodlabTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp(name: List<String> = listOf("g", "m")) {
    Column(Modifier.padding(14.dp)) {
        for (i in name) {
            Greeting(name = i)
        }
    }

}

@Composable
fun Greeting(name: String) {

    // 앱에 넣고자 하는 공통 기능을 처리한다.
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(24.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "hello.")
                Text(text = name)
            }
            OutlinedButton(
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Show more")
            }


        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeCodlabTheme {
        Greeting("Android")
    }
}

