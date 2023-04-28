package com.techmania.radiobuttons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techmania.radiobuttons.ui.theme.RadioButtonsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RadioButtonsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    RadioButtonExample()
                }
            }
        }
    }
}

@Composable
fun RadioButtonExample() {

    val myBackgroundColor = remember {
        mutableStateOf(Color.White)
    }
    val radioIndex = remember {
        mutableStateOf(0)
    }
    val radioTexts = listOf("Red", "Green", "Yellow", "Gray")
    val colorList = arrayListOf(Color.Red,Color.Green,Color.Yellow, Color.Gray)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(myBackgroundColor.value),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        
        Column() {
            
            Spacer(modifier = Modifier.size(75.dp))
            
            radioTexts.forEachIndexed { position, name ->

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable {
                        radioIndex.value = position
                        //myBackgroundColor.value = colorList[radioIndex.value]
                    }) {
                    RadioButton(
                        selected = name == radioTexts[radioIndex.value],
                        onClick = {
                            radioIndex.value = position
                            //myBackgroundColor.value = colorList[radioIndex.value]
                            //you can create when statement
                        },
                        colors = RadioButtonDefaults.colors(Color.Blue)
                    )

                    Text(text = name)
                }

            }

            Spacer(modifier = Modifier.size(50.dp))

        }

        Button(
            onClick = {
                myBackgroundColor.value = colorList[radioIndex.value]
            }) {
            Text(text = "Change Background Color")
        }

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RadioButtonsTheme {
        RadioButtonExample()
    }
}