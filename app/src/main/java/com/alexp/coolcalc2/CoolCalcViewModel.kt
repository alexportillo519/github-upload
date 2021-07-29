package com.alexp.coolcalc2

class CoolCalcViewModel {

    fun calculate(operator: String?, firstNumber: Double?, secondNumber: Double?): Double? {

        return when (operator) {
            "+" -> secondNumber?.plus(firstNumber!!)
            "-" -> firstNumber?.minus(secondNumber!!)
            "*" -> firstNumber?.times(secondNumber!!)
            "/" -> firstNumber?.div(secondNumber!!)
            else -> 0.0
        }
    }
}