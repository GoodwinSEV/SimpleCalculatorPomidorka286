package com.example.simplecalculatorpomidorka286

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

//Просто вычисления
class CalculatorLogic {
    fun add(a: Double, b: Double): Double = a + b
    fun subtract(a: Double, b: Double): Double = a - b
    fun multiply(a: Double, b: Double): Double = a * b
    fun divide(a: Double, b: Double): Double {
        if (b == 0.0) throw ArithmeticException("eRRor")
        return a / b
    }
}

//Основной класс
class CalculatorState {
    //Ввод
    var currentInput by mutableStateOf("0")
    var operation by mutableStateOf("")
    //Вывод
    var shouldResetInput by mutableStateOf(false)

    private val logic = CalculatorLogic()
    private var previousValue: Double = 0.0

    //Ввод цифр
    fun inputDigit(digit: String) {
        if (shouldResetInput) {
            currentInput = digit
            shouldResetInput = false
        } else {
            currentInput = if (currentInput == "0") digit else currentInput + digit
        }
    }

    //Ввод операций
    fun inputOperation(newOperation: String) {
        if (currentInput.isNotEmpty()) {
            if (operation.isNotEmpty() && !shouldResetInput) {
                performCalculation()
            }
            operation = newOperation
            previousValue = currentInput.toDouble()
            shouldResetInput = true
        }
    }

    //Вычисление
    fun performCalculation() {
        if (operation.isNotEmpty() && currentInput.isNotEmpty()) {
            try {
                val current = currentInput.toDouble()
                val result = when (operation) {
                    "+" -> logic.add(previousValue, current)
                    "-" -> logic.subtract(previousValue, current)
                    "×" -> logic.multiply(previousValue, current)
                    "÷" -> logic.divide(previousValue, current)
                    else -> current
                }

                currentInput = if (result % 1 == 0.0) {
                    result.toInt().toString()
                } else {
                    result.toString()
                }
                operation = ""
                shouldResetInput = true
            } catch (e: ArithmeticException) {
                currentInput = "Error"
                operation = ""
                shouldResetInput = true
            }
        }
    }

    // Очистка всего
    fun clearAll() {
        currentInput = "0"
        operation = ""
        previousValue = 0.0
        shouldResetInput = false
    }
}