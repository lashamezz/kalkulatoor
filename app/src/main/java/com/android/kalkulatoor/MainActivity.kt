package com.android.kalkulatoor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TextView
import kotlin.math.pow
import kotlin.text.dropLast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView

    private var operand : Double = 0.0
    private var operation : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultTextView = findViewById(R.id.resultTextView)
        resultTextView.text = "0"
    }


    fun numberClick(view: View){

        if(view is TextView){

            var result: String = resultTextView.text.toString()
            val number: String = view.text.toString()

            if (result == "0"){
                result = ""
            }

            resultTextView.text = result + number

        }

    }

    fun operationClick(view: View){

        if (view is TextView){

            if(!TextUtils.isEmpty(resultTextView.text)) {
                operand = resultTextView.text.toString().toDouble()
            }

            operation = view.text.toString()

            resultTextView.text = ""
        }

    }

    fun equalsClick(view: View){
        var secOperandText: String = resultTextView.text.toString()
        var secOperand: Double = 0.0

        if(!TextUtils.isEmpty(secOperandText)){
            secOperand = secOperandText.toDouble()
        }

        when(operation){
            "+" -> resultTextView.text = (operand + secOperand).toString()
            "-" -> resultTextView.text = (operand - secOperand).toString()
            "*" -> resultTextView.text = (operand * secOperand).toString()
            "÷" -> resultTextView.text = (operand / secOperand).toString()
            "%" -> resultTextView.text = ((operand / secOperand)* 100.0).toString()
            "^" -> resultTextView.text = (operand.pow(secOperand).toString())
        }
    }

    fun clearAll(view: View){
        if(view is TextView){
            resultTextView.text = "0"
        }
    }

    fun del(view: View) {
        if (resultTextView.text != "0") {
            resultTextView.text = resultTextView.text.dropLast(1)
        }

    }

}