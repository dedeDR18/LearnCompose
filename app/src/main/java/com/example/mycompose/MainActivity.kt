package com.example.mycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycompose.ui.theme.MyComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp(){
    MyComposeTheme() {
        Column( modifier = Modifier.padding(24.dp)) {
            ShowImage()
            Spacer(Modifier.height(16.dp))
            Greeting("DEDE DARI RAHMADI")
            Spacer(Modifier.height(16.dp))
            ShowList()
            Spacer(Modifier.height(16.dp))
            ClickCount()
        }
    }
}

@Composable
fun Greeting(name: String) {
    val typography = MaterialTheme.typography

        Text(text = "Hello $name!", style = typography.h6)
        Text(text = "Selamat Datang !!!", style = typography.body2)
        Text(text = "Kita Cobain Compose yuk.. wkwkwkwkwkwkwkkwkwkwkwkwkwkwkwkwkwwkwkwkwkwkkwkwkwkwkwkwkwkwkwkwkkwkwkwkwkwkwkwkwkwkwkwkkwkwkwkwkwkwkasdasdasdkjashdkjashdkjhaskjdakshdjkahskdajsk",
            style = typography.body2,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
            )
}

@Composable
fun ShowImage(){
    Image(
        painter = painterResource(id = R.drawable.sunset),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(10.dp))
        )
}

@Composable
fun ShowList(listNama: List<String> = listOf("Dede", "Dari", "Rahmadi")){
    Column {
        for (list in listNama){
            Text(list)
            Divider(color = Color.Black)
        }
    }
}

@Composable
fun ClickCount(){
    val count = remember { mutableStateOf(0)}
    Button(onClick = {count.value++}) {
        Text("sudah diclick ${count.value} kali")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}