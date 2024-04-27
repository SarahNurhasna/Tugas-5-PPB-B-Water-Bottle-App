package com.example.waterbottle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.waterbottle.ui.theme.WaterBottleTheme
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaterBottleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var usedAmount by remember {
                        mutableStateOf(400)
                    }

                    var totalWaterAmount = remember {
                        2200
                    }
                    Column (
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        WaterBottle(
                            totalWaterAmount = totalWaterAmount,
                            unit = "ml",
                            usedWaterAmount = usedAmount
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(text = "Total amount: ${totalWaterAmount-200} ml")
                        Button(onClick = { usedAmount += 200}) {
                            Text(text = "Drink")
                        }

                    }
                }
            }
        }
    }
}
