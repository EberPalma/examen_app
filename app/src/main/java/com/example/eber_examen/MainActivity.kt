package com.example.eber_examen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mathOperation = ""
        var operations = ArrayList<String>()
        // operations.add(var) para añadir elementos al array
        var actualOperation = ""
        var resoult = 0.0
        var index = 0
        var lastOperator: Char = '!'

        math_area.text = mathOperation
        actual_operation.text = "0"

        // Numeros
        one.setOnClickListener {
            actualOperation += "1"
            mathOperation += "1"

            doActualOperation(operations, lastOperator, resoult, index, actualOperation)

            math_area.text = mathOperation
        }
        two.setOnClickListener {
            actualOperation += "2"
            mathOperation += "2"

            doActualOperation(operations, lastOperator, resoult, index, actualOperation)

            math_area.text = mathOperation
        }
        three.setOnClickListener {
            actualOperation += "3"
            mathOperation += "3"

            doActualOperation(operations, lastOperator, resoult, index, actualOperation)

            math_area.text = mathOperation
        }
        four.setOnClickListener {
            actualOperation += "4"
            mathOperation += "4"

            doActualOperation(operations, lastOperator, resoult, index, actualOperation)

            math_area.text = mathOperation
        }
        five.setOnClickListener {
            actualOperation += "5"
            mathOperation += "5"

            doActualOperation(operations, lastOperator, resoult, index, actualOperation)

            math_area.text = mathOperation
        }
        six.setOnClickListener {
            actualOperation += "6"
            mathOperation += "6"

            doActualOperation(operations, lastOperator, resoult, index, actualOperation)

            math_area.text = mathOperation
        }
        seven.setOnClickListener {
            actualOperation += "7"
            mathOperation += "7"

            doActualOperation(operations, lastOperator, resoult, index, actualOperation)

            math_area.text = mathOperation
        }
        eigth.setOnClickListener {
            actualOperation += "8"
            mathOperation += "8"

            doActualOperation(operations, lastOperator, resoult, index, actualOperation)

            math_area.text = mathOperation
        }
        nine.setOnClickListener {
            actualOperation += "9"
            mathOperation += "9"

            doActualOperation(operations, lastOperator, resoult, index, actualOperation)

            math_area.text = mathOperation
        }
        cero.setOnClickListener {
            actualOperation += "0"
            mathOperation += "0"

            doActualOperation(operations, lastOperator, resoult, index, actualOperation)

            math_area.text = mathOperation
        }
        point.setOnClickListener {
            if(!actualOperation.contains(".")) {
                actualOperation += "."
                mathOperation += "."

                resoult = doActualOperation(operations, lastOperator, resoult, index, actualOperation)

                math_area.text = mathOperation
            }
        }
        // Operadores
        plus.setOnClickListener {
            if(!mathOperation.isEmpty()){
                operations.add(actualOperation)
                resoult = doActualOperation(operations, lastOperator, resoult, index, actualOperation)
                lastOperator = '+'
                index ++
                actualOperation = ""
                mathOperation += "+"
                math_area.text = mathOperation
            }
        }
        less.setOnClickListener {
            if(!mathOperation.isEmpty()) {
                operations.add(actualOperation)
                resoult = doActualOperation(operations, lastOperator, resoult, index, actualOperation)
                lastOperator = '-'
                index++
                actualOperation = ""
                mathOperation += "-"
                math_area.text = mathOperation
            }
        }
        divition.setOnClickListener {
            if(!mathOperation.isEmpty()) {
                operations.add(actualOperation)
                resoult = doActualOperation(operations, lastOperator, resoult, index, actualOperation)
                lastOperator = '/'
                index++
                actualOperation = ""
                mathOperation += "/"
                math_area.text = mathOperation
            }
        }
        multiply.setOnClickListener {
            if(!mathOperation.isEmpty()) {
                operations.add(actualOperation)
                resoult = doActualOperation(operations, lastOperator, resoult, index, actualOperation)
                lastOperator = '*'
                index++
                actualOperation = ""
                mathOperation += "*"
                math_area.text = mathOperation
            }
        }

        // Deletes
        clear.setOnClickListener {
            actualOperation = ""
            mathOperation = ""
            lastOperator = '!'
            index = 0
            resoult = 0.0
            math_area.text = mathOperation
            actual_operation.text = "0"
            operations.clear()
        }
        delete.setOnClickListener {
            if(!mathOperation.isEmpty()){
                mathOperation = mathOperation.substring(0, mathOperation.length -1)
                actualOperation = actualOperation.substring(0, actualOperation.length - 1)
                math_area.text = mathOperation
            }
        }

        // Calcular
        equals.setOnClickListener{
            if(!mathOperation.isEmpty()){
                resoult = doActualOperation(operations, lastOperator, resoult, index, actualOperation)
                mathOperation = resoult.toString()
                math_area.text = mathOperation
            }
        }
    }

    fun doActualOperation(operations: ArrayList<String>, lastOperator: Char, result: Double, index: Int, actualOperation: String): Double{
        var finalValue: Double = 0.0
        if(lastOperator == '!'){
            finalValue = actualOperation.toDouble()
        }
        if(lastOperator == '+'){
            finalValue = result + actualOperation.toDouble()
        }
        if(lastOperator == '-'){
            finalValue = result - actualOperation.toDouble()
        }
        if(lastOperator == '/'){
            if(actualOperation.length == 1 && actualOperation.toInt() == 0){
            }else {
                finalValue = result / actualOperation.toDouble()
            }
        }
        if(lastOperator == '*'){
            finalValue = result * actualOperation.toDouble()
        }
        actual_operation.text = finalValue.toString()
        return finalValue
    }
}