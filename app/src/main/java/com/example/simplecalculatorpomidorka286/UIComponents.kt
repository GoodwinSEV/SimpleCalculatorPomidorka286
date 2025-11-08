package com.example.simplecalculatorpomidorka286

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CalculatorDisplay(value: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFF95978D), RoundedCornerShape(10.dp))
            .padding(16.dp),
        contentAlignment = Alignment.CenterEnd
    ) {
        Text(
            text = value,
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White
        )
    }
}

@Composable
fun CalculatorButton(
    symbol: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Gray,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(containerColor = color),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            text = symbol,
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White
        )
    }
}

@Composable
fun CalculatorKeypad(
    onButtonClick: (String) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CalculatorButton(
                symbol = "1",
                modifier = Modifier.weight(1f),
                color = Color(0xFFD71F5F),
                onClick = { onButtonClick("1") }
            )
            CalculatorButton(
                symbol = "2",
                modifier = Modifier.weight(1f),
                color = Color(0xFFD71F5F),
                onClick = { onButtonClick("2") }
            )
            CalculatorButton(
                symbol = "3",
                modifier = Modifier.weight(1f),
                color = Color(0xFFD71F5F),
                onClick = { onButtonClick("3") }
            )
            CalculatorButton(
                symbol = "-",
                modifier = Modifier.weight(1f),
                color = Color(0xFF0A9ADC),
                onClick = { onButtonClick("-") }
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CalculatorButton(
                symbol = "4",
                modifier = Modifier.weight(1f),
                color = Color(0xFFD71F5F),
                onClick = { onButtonClick("4") }
            )
            CalculatorButton(
                symbol = "5",
                modifier = Modifier.weight(1f),
                color = Color(0xFFD71F5F),
                onClick = { onButtonClick("5") }
            )
            CalculatorButton(
                symbol = "6",
                modifier = Modifier.weight(1f),
                color = Color(0xFFD71F5F),
                onClick = { onButtonClick("6") }
            )
            CalculatorButton(
                symbol = "×",
                modifier = Modifier.weight(1f),
                color = Color(0xFF0A9ADC),
                onClick = { onButtonClick("×") }
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CalculatorButton(
                symbol = "7",
                modifier = Modifier.weight(1f),
                color = Color(0xFFD71F5F),
                onClick = { onButtonClick("7") }
            )
            CalculatorButton(
                symbol = "8",
                modifier = Modifier.weight(1f),
                color = Color(0xFFD71F5F),
                onClick = { onButtonClick("8") }
            )
            CalculatorButton(
                symbol = "9",
                modifier = Modifier.weight(1f),
                color = Color(0xFFD71F5F),
                onClick = { onButtonClick("9") }
            )
            CalculatorButton(
                symbol = "÷",
                modifier = Modifier.weight(1f),
                color = Color(0xFF0A9ADC),
                onClick = { onButtonClick("÷") }
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {CalculatorButton(
            symbol = "C",
            modifier = Modifier.weight(1f),
            color = Color(0xFFA5A5A5),
            onClick = { onButtonClick("C") }
        )
            CalculatorButton(
                symbol = "0",
                modifier = Modifier.weight(1f),
                color = Color(0xFFD71F5F),
                onClick = { onButtonClick("0") }
            )
            CalculatorButton(
                symbol = "=",
                modifier = Modifier.weight(1f),
                color = Color(0xFF0A9ADC),
                onClick = { onButtonClick("=") }
            )
            CalculatorButton(
                symbol = "+",
                modifier = Modifier.weight(1f),
                color = Color(0xFF0A9ADC),
                onClick = { onButtonClick("+") }
            )
        }
        }
    }
