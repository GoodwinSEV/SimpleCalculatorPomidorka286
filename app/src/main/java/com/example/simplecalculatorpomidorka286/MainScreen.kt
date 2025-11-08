package com.example.simplecalculatorpomidorka286

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.simplecalculatorpomidorka286.ui.theme.SimpleCalculatorPomidorka286Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleCalculatorPomidorka286Theme {
                    MainScreen(
                    )
            }
        }
    }
}

@Composable
fun MainScreen() {
    val calculatorState = remember { CalculatorState() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CalculatorDisplay(
            value = calculatorState.currentInput,
            modifier = Modifier.fillMaxWidth()
        )

        CalculatorKeypad { button ->
            when (button) {
                "C" -> calculatorState.clearAll()
                "+", "-", "×", "÷" -> calculatorState.inputOperation(button)
                "=" -> calculatorState.performCalculation()
                else -> calculatorState.inputDigit(button)
            }
        }
    }
}