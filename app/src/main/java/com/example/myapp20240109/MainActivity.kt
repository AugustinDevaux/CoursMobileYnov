package com.example.myapp20240109

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var textFieldTop: EditText
    private lateinit var textFieldBottom: EditText
    private lateinit var resultOutputTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textFieldTop = findViewById(R.id.textFieldTop)
        textFieldBottom = findViewById(R.id.textFieldBottom)
        resultOutputTextView = findViewById(R.id.resultOutputTextView)

        val additionButton: Button = findViewById(R.id.additionButton)
        val substractionButton: Button = findViewById(R.id.substractionButton)
        val multiplyButton: Button = findViewById(R.id.multiplyButton)
        val divideButton: Button = findViewById(R.id.divideButton)

        additionButton.setOnClickListener { calculateResult(it) }
        substractionButton.setOnClickListener { calculateResult(it) }
        multiplyButton.setOnClickListener { calculateResult(it) }
        divideButton.setOnClickListener { calculateResult(it) }

    }

    private fun calculateResult(view: View){
        val firstNumber = textFieldTop.text.toString().toFloatOrNull() ?: 0
        val secondNumber = textFieldBottom.text.toString().toFloatOrNull() ?: 0

        val resultOutput: Comparable<*> = when (view.id) {
            R.id.additionButton -> firstNumber.toFloat() + secondNumber.toFloat()
            R.id.substractionButton -> firstNumber.toFloat() - secondNumber.toFloat()
            R.id.multiplyButton -> firstNumber.toFloat() * secondNumber.toFloat()
            R.id.divideButton -> (if (secondNumber.toFloat() != 0.toFloat()) firstNumber.toFloat() / secondNumber.toFloat() else "Division Impossible")
            else -> 0
        }

        resultOutputTextView.text = "Résultat : $resultOutput"

    }







}