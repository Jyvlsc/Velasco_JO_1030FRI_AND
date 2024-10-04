package com.ucb.midterm.calculator

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var display: TextView? = null
    private val currentInput = StringBuilder()
    private var firstNumber = 0.0
    private var operator = ""
    private var operatorClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById<TextView>(R.id.display)

        findViewById<View>(R.id.button_double_zero).setOnClickListener { v: View? ->
            appendNumber(
                "00"
            )
        }

        findViewById<View>(R.id.button_0).setOnClickListener { v: View? ->
            appendNumber(
                "0"
            )
        }
        findViewById<View>(R.id.button_1).setOnClickListener { v: View? ->
            appendNumber(
                "1"
            )
        }
        findViewById<View>(R.id.button_2).setOnClickListener { v: View? ->
            appendNumber(
                "2"
            )
        }
        findViewById<View>(R.id.button_3).setOnClickListener { v: View? ->
            appendNumber(
                "3"
            )
        }
        findViewById<View>(R.id.button_4).setOnClickListener { v: View? ->
            appendNumber(
                "4"
            )
        }
        findViewById<View>(R.id.button_5).setOnClickListener { v: View? ->
            appendNumber(
                "5"
            )
        }
        findViewById<View>(R.id.button_6).setOnClickListener { v: View? ->
            appendNumber(
                "6"
            )
        }
        findViewById<View>(R.id.button_7).setOnClickListener { v: View? ->
            appendNumber(
                "7"
            )
        }
        findViewById<View>(R.id.button_8).setOnClickListener { v: View? ->
            appendNumber(
                "8"
            )
        }
        findViewById<View>(R.id.button_9).setOnClickListener { v: View? ->
            appendNumber(
                "9"
            )
        }
        findViewById<View>(R.id.button_decimal).setOnClickListener { v: View? ->
            appendNumber(
                "."
            )
        }

        findViewById<View>(R.id.button_add).setOnClickListener { v: View? ->
            handleOperator(
                "+"
            )
        }
        findViewById<View>(R.id.button_subtract).setOnClickListener { v: View? ->
            handleOperator(
                "-"
            )
        }
        findViewById<View>(R.id.button_multiply).setOnClickListener { v: View? ->
            handleOperator(
                "*"
            )
        }
        findViewById<View>(R.id.button_divide).setOnClickListener { v: View? ->
            handleOperator(
                "/"
            )
        }

        findViewById<View>(R.id.button_equals).setOnClickListener { v: View? -> calculateResult() }

        findViewById<View>(R.id.button_cancel).setOnClickListener { v: View? -> clearDisplay() }

        findViewById<View>(R.id.button_percentage).setOnClickListener { v: View? ->
            if (currentInput.length > 0) {
                val percentage = currentInput.toString().toDouble() / 100
                display!!.text = percentage.toString()
                currentInput.setLength(0)
                currentInput.append(percentage)
            }
        }

        findViewById<View>(R.id.button_delete).setOnClickListener { v: View? ->
            if (currentInput.length > 0) {
                currentInput.deleteCharAt(currentInput.length - 1)
                display!!.text = if (currentInput.isNotEmpty()) currentInput.toString() else "0"
            }
        }

    }

    private fun appendNumber(number: String) {
        if (operatorClicked) {
            currentInput.setLength(0)
            operatorClicked = false
        }
        currentInput.append(number)
        display!!.text = currentInput.toString()
    }

    private fun handleOperator(selectedOperator: String) {
        if (currentInput.length > 0) {
            firstNumber = currentInput.toString().toDouble()
            operator = selectedOperator
            display!!.text = operator
            operatorClicked = true
        }
    }

    private fun calculateResult() {
        if (currentInput.length > 0 && !operator.isEmpty()) {
            val secondNumber = currentInput.toString().toDouble()
            var result = 0.0

            when (operator) {
                "+" -> result = firstNumber + secondNumber
                "-" -> result = firstNumber - secondNumber
                "*" -> result = firstNumber * secondNumber
                "/" -> if (secondNumber != 0.0) {
                    result = firstNumber / secondNumber
                } else {
                    display!!.text = "Error"
                    return
                }
            }

            if (result == result.toInt().toDouble()) {
                display!!.text = result.toInt().toString()
            } else {
                display!!.text = result.toString()
            }

            currentInput.setLength(0)
            currentInput.append(result)
            operator = ""
        }
    }

    private fun clearDisplay() {
        display!!.text = "0"
        currentInput.setLength(0)
        firstNumber = 0.0
        operator = ""
        operatorClicked = false
    }
}