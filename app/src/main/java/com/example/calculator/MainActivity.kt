package com.example.calculator

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        setContentView(R.layout.activity_main)

        one.setOnClickListener {
            evaluateExpression("1", clear = true)
        }
        two.setOnClickListener {
            evaluateExpression("2", clear = true)
        }
        three.setOnClickListener {
            evaluateExpression("3", clear = true)
        }
        four.setOnClickListener {
            evaluateExpression("4", clear = true)
        }
        five.setOnClickListener {
            evaluateExpression("5", clear = true)
        }
        six.setOnClickListener {
            evaluateExpression("6", clear = true)
        }
        seven.setOnClickListener {
            evaluateExpression("7", clear = true)
        }
        eight.setOnClickListener {
            evaluateExpression("8", clear = true)
        }
        nine.setOnClickListener {
            evaluateExpression("9", clear = true)
        }
        zero.setOnClickListener {
            evaluateExpression("0", clear = true)
        }
        add.setOnClickListener {
            evaluateExpression("+", clear = true)
        }
        minus.setOnClickListener {
            evaluateExpression("-", clear = true)
        }
        mult.setOnClickListener {
            evaluateExpression("*", clear = true)
        }
        div.setOnClickListener {
            evaluateExpression("/", clear = true)
        }
        dot.setOnClickListener {
            evaluateExpression(".", clear = true)
        }
        pow.setOnClickListener {
            evaluateExpression("^", clear = true)
        }
        clear.setOnClickListener {
            textView.text = " "
            textView2.text = " "
        }
        equal.setOnClickListener {
            try {
                val text = textView.text.toString()
                val expression = ExpressionBuilder(text).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    textView2.text = longResult.toString()
                } else {
                    textView2.text = result.toString()
                }

            } catch (e: Exception) {
                Log.d("Exception", "message:" + e.message)
            }
        }
        delete.setOnClickListener {
            val text = textView.text.toString()
            if (text.isNotEmpty()){
                textView.text = text.dropLast(1)
            }
            textView2.text = " "
        }

    }
    

    fun evaluateExpression(string: String, clear: Boolean) {

        if (clear) {
            textView2.text = " "
            textView.append(string)
        } 
        else {
            textView.append(textView2.text)
            textView.append(string)
            textView2.text = ""
        }

    }
}