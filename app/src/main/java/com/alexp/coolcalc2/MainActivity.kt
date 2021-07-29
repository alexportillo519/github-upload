package com.alexp.coolcalc2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val viewModel = CoolCalcViewModel()
    private var userInput: String? = ""
    private var firstNumber: Double? = 0.0
    private var secondNumber: Double? = 0.0
    private var operationClicked: String? = ""
    private var equalsClicked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val zeroButton = findViewById<Button>(R.id.zero_button)
        val oneButton = findViewById<Button>(R.id.one_button)
        val twoButton = findViewById<Button>(R.id.two_button)
        val threeButton = findViewById<Button>(R.id.three_button)
        val fourButton = findViewById<Button>(R.id.four_button)
        val fiveButton = findViewById<Button>(R.id.five_button)
        val sixButton = findViewById<Button>(R.id.six_button)
        val sevenButton = findViewById<Button>(R.id.seven_button)
        val eightButton = findViewById<Button>(R.id.eight_button)
        val nineButton = findViewById<Button>(R.id.nine_button)
        val answerText = findViewById<TextView>(R.id.answer_text)
        val acButton = findViewById<Button>(R.id.ac_button)
        val decimalButton = findViewById<Button>(R.id.decimal_button)
        val deleteButton = findViewById<Button>(R.id.delete_button)
        val signButton = findViewById<Button>(R.id.sign_button)
        val addButton = findViewById<Button>(R.id.add_button)
        val subtractButton = findViewById<Button>(R.id.subtract_button)
        val multiplyButton = findViewById<Button>(R.id.multiply_button)
        val divideButton = findViewById<Button>(R.id.divide_button)
        val equalButton = findViewById<Button>(R.id.equals_button)
        val equationText = findViewById<TextView>(R.id.equation_text)

        zeroButton.setOnClickListener {
            updateUserInput("0")
        }

        oneButton.setOnClickListener {
            updateUserInput("1")
        }

        twoButton.setOnClickListener {
            updateUserInput("2")
        }

        threeButton.setOnClickListener {
            updateUserInput("3")
        }

        fourButton.setOnClickListener {
            updateUserInput("4")
        }

        fiveButton.setOnClickListener {
            updateUserInput("5")
        }

        sixButton.setOnClickListener {
            updateUserInput("6")
        }

        sevenButton.setOnClickListener {
            updateUserInput("7")
        }

        eightButton.setOnClickListener {
            updateUserInput("8")
        }

        nineButton.setOnClickListener {
            updateUserInput("9")
        }

        acButton.setOnClickListener {
            userInput = ""
            answerText.text = userInput
            equationText.text = ""
        }

        decimalButton.setOnClickListener {
            updateUserInput(".")
        }

        deleteButton.setOnClickListener {
            userInput = userInput?.dropLast(1)
            answerText.text = userInput
        }

        signButton.setOnClickListener {
            if(!userInput!!.contains("-")) {
                userInput = userInput!!.prependIndent("-")
                answerText.text = userInput
            } else {
                userInput = userInput!!.drop(1)
                answerText.text = userInput
            }
        }

        addButton.setOnClickListener {
            firstNumber = answerText.text?.toString()?.toDouble() ?: 0.0
            operationClicked = "+"
            userInput = ""
        }

        subtractButton.setOnClickListener {
            firstNumber = answerText.text?.toString()?.toDouble() ?: 0.0
            operationClicked = "-"
            userInput = ""
        }

        multiplyButton.setOnClickListener {
            firstNumber = answerText.text?.toString()?.toDouble() ?: 0.0
            operationClicked = "*"
            userInput = ""
        }

        divideButton.setOnClickListener {
            firstNumber = answerText.text?.toString()?.toDouble() ?: 0.0
            operationClicked = "/"
            userInput = ""
        }

        equalButton.setOnClickListener {
            secondNumber = answerText.text?.toString()?.toDouble() ?: 0.0
            answerText.text = viewModel.calculate(operationClicked, firstNumber, secondNumber).toString()
            equationText.text = "$firstNumber $operationClicked $secondNumber"
            operationClicked = ""
            equalsClicked = true
        }
    }

    private fun updateUserInput(number: String) {
        if(equalsClicked) {
            userInput = ""
            equalsClicked = false
        }
        val answerText = findViewById<TextView>(R.id.answer_text)
        userInput += number
        answerText.text = userInput
    }
}