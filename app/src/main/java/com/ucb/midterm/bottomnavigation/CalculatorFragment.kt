package com.ucb.midterm.bottomnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class CalculatorFragment : Fragment() {
    private var display: TextView? = null
    private val currentInput = StringBuilder()
    private var firstNumber = 0.0
    private var operator = ""
    private var operatorClicked = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_calculator, container, false)

        display = view.findViewById(R.id.display)

        view.findViewById<View>(R.id.button_0).setOnClickListener { appendNumber("0") }
        view.findViewById<View>(R.id.button_1).setOnClickListener { appendNumber("1") }
        view.findViewById<View>(R.id.button_2).setOnClickListener { appendNumber("2") }
        view.findViewById<View>(R.id.button_3).setOnClickListener { appendNumber("3") }
        view.findViewById<View>(R.id.button_4).setOnClickListener { appendNumber("4") }
        view.findViewById<View>(R.id.button_5).setOnClickListener { appendNumber("5") }
        view.findViewById<View>(R.id.button_6).setOnClickListener { appendNumber("6") }
        view.findViewById<View>(R.id.button_7).setOnClickListener { appendNumber("7") }
        view.findViewById<View>(R.id.button_8).setOnClickListener { appendNumber("8") }
        view.findViewById<View>(R.id.button_9).setOnClickListener { appendNumber("9") }
        view.findViewById<View>(R.id.button_decimal).setOnClickListener { appendNumber(".") }
        view.findViewById<View>(R.id.button_add).setOnClickListener { handleOperator("+") }
        view.findViewById<View>(R.id.button_subtract).setOnClickListener { handleOperator("-") }
        view.findViewById<View>(R.id.button_multiply).setOnClickListener { handleOperator("*") }
        view.findViewById<View>(R.id.button_divide).setOnClickListener { handleOperator("/") }

        view.findViewById<View>(R.id.button_equals).setOnClickListener { calculateResult() }
        view.findViewById<View>(R.id.button_clear).setOnClickListener { clearDisplay() }

        return view

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
        if (currentInput.isNotEmpty()) {
            firstNumber = currentInput.toString().toDouble()
            operator = selectedOperator
            display!!.text = operator
            operatorClicked = true
        }
    }

    private fun calculateResult() {
        if (currentInput.isNotEmpty() && operator.isNotEmpty()) {
            val secondNumber = currentInput.toString().toDouble()
            var result = 0.0

            when (operator) {
                "+" -> result = firstNumber + secondNumber
                "-" -> result = firstNumber - secondNumber
                "*" -> result = firstNumber * secondNumber
                "/" -> result = if (secondNumber != 0.0) firstNumber / secondNumber else {
                    display!!.text = "Error"
                    return
                }
            }

            display!!.text = if (result == result.toInt().toDouble()) {
                result.toInt().toString()
            } else {
                result.toString()
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