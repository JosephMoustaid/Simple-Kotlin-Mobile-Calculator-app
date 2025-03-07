package com.example.simplecalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.simplecalculator.R

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private var currentInput = ""
    private var currentOperator = ""
    private var firstNumber = 0.0
    private var secondNumber = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)

        // Set up number buttons
        val numberButtons = listOf(
            findViewById<Button>(R.id.button0),
            findViewById<Button>(R.id.button1),
            findViewById<Button>(R.id.button2),
            findViewById<Button>(R.id.button3),
            findViewById<Button>(R.id.button4),
            findViewById<Button>(R.id.button5),
            findViewById<Button>(R.id.button6),
            findViewById<Button>(R.id.button7),
            findViewById<Button>(R.id.button8),
            findViewById<Button>(R.id.button9)
        )

        for (button in numberButtons) {
            button.setOnClickListener {
                currentInput += button.text
                updateDisplay()
            }
        }

        // Set up operator buttons
        val operatorButtons = listOf(
            findViewById<Button>(R.id.buttonAdd),
            findViewById<Button>(R.id.buttonSubtract),
            findViewById<Button>(R.id.buttonMultiply),
            findViewById<Button>(R.id.buttonDivide)
        )

        for (button in operatorButtons) {
            button.setOnClickListener {
                if (currentInput.isNotEmpty()) {
                    firstNumber = currentInput.toDouble()
                    currentOperator = button.text.toString()
                    currentInput = ""
                    updateDisplay()
                }
            }
        }

        // Clear button
        findViewById<Button>(R.id.buttonClear).setOnClickListener {
            currentInput = ""
            currentOperator = ""
            firstNumber = 0.0
            secondNumber = 0.0
            updateDisplay()
        }

        // Equals button
        findViewById<Button>(R.id.buttonEquals).setOnClickListener {
            if (currentInput.isNotEmpty() && currentOperator.isNotEmpty()) {
                secondNumber = currentInput.toDouble()
                val result = when (currentOperator) {
                    "+" -> firstNumber + secondNumber
                    "-" -> firstNumber - secondNumber
                    "*" -> firstNumber * secondNumber
                    "/" -> firstNumber / secondNumber
                    else -> 0.0
                }
                currentInput = result.toString()
                currentOperator = ""
                updateDisplay()
            }
        }
    }

    private fun updateDisplay() {
        resultTextView.text = currentInput
    }
}