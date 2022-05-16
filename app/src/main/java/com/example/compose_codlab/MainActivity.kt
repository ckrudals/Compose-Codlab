package com.example.compose_codlab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_codlab.ui.theme.ComposeCodlabTheme
import androidx.compose.foundation.lazy.items

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCodlabTheme {
                // A surface container using the 'background' color from the theme
                MyApp()

            }
        }
    }
}

@Composable
fun MyApp() {
    var shouldShowOnboarding by remember { mutableStateOf(true) }

    if (shouldShowOnboarding) {
        OnboardingScreen(onContinueClicked = {
            shouldShowOnboarding = false
        })
    } else {
        Greetings()
    }

}

@Composable
fun OnboardingScreen(onContinueClicked: () -> Unit) {

    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text("Welcome to the Basics Codelab!")
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = onContinueClicked
            ) {
                Text(text = "Continue")
            }
        }
    }

}


@Composable
fun Greetings(name: List<String> = List(1000) { "${it}" }) {
    LazyColumn(Modifier.padding(vertical = 4.dp)) {
        items(name) { name ->
            Greeting(name = name)
        }
    }

}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    ComposeCodlabTheme {

        OnboardingScreen {}
    }
}

@Composable
fun Greeting(name: String) {

    // 상태 저장할 변수
    val expanded = remember {
        mutableStateOf(false)
    }
    val extraPadding = if (expanded.value) 48.dp else 0.dp
    // 앱에 넣고자 하는 공통 기능을 처리한다.
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(24.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(text = "hello.")
                Text(text = name)
            }
            OutlinedButton(
                // 클릭하면 반대가 됨

                onClick = { expanded.value = !expanded.value }
            ) {
                Text(text = if (expanded.value) "Show more" else "fuck")
            }


        }

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeCodlabTheme {
        Greetings()
    }
}

