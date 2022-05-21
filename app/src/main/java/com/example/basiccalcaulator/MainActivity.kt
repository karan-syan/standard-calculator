package com.example.basiccalcaulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.basiccalcaulator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        printinput()


    }
    private fun printinput(){
            var lastnumeric = false
            var lastdot = false
        binding.apply {
            btn0.setOnClickListener{
                textarea.append(btn0.text)
                lastnumeric = true
            }
            btn1.setOnClickListener{
                textarea.append(btn1.text)
                lastnumeric = true
            }
            btn2.setOnClickListener{
                textarea.append(btn2.text)
                lastnumeric = true
            }
            btn3.setOnClickListener{
                textarea.append(btn3.text)
                lastnumeric = true
            }
            btn4.setOnClickListener{
                textarea.append(btn4.text)
                lastnumeric = true
            }
            btn5.setOnClickListener{
                textarea.append(btn5.text)
                lastnumeric = true
            }
            btn6.setOnClickListener{
                textarea.append(btn6.text)
                lastnumeric = true
            }
            btn7.setOnClickListener{
                textarea.append(btn7.text)
                lastnumeric = true
            }
            btn8.setOnClickListener{
                textarea.append(btn8.text)
                lastnumeric = true
            }
            btn9.setOnClickListener{
                textarea.append(btn9.text)
                lastnumeric = true
            }
            btn00.setOnClickListener{
                textarea.append(btn00.text)
                lastnumeric = true
            }
            btnsubs.setOnClickListener{
                if (lastnumeric){
                    textarea.append(btnsubs.text)
                    lastnumeric = false
                }
            }
            btnclear.setOnClickListener{
                textarea.text = " "
                lastdot = false
                lastnumeric = false
            }
            btnadd.setOnClickListener{
                if (lastnumeric){
                    textarea.append(btnadd.text)
                    lastnumeric = false
                }
            }
            btndot.setOnClickListener{
                if (lastnumeric && !lastdot){
                    textarea.append(btndot.text)
                    lastdot = true
                }
            }
            btndivide.setOnClickListener{
                if (lastnumeric){
                    textarea.append(btndivide.text)
                    lastnumeric = false
                }
            }
            btnpercent.setOnClickListener{
                if (lastnumeric){
                    textarea.append(btnpercent.text)
                    lastnumeric = false
                }
            }
            btnspaceback.setOnClickListener{
                if(textarea.text.isEmpty()) {
                    val str: String =
                        textarea.text.toString().substring(0, textarea.text.toString().length - 1)
                    textarea.text = str
                }
            }
            btnmultiply.setOnClickListener{
                if (lastnumeric){
                    textarea.append(btnmultiply.text)
                    lastnumeric = false
                }
            }

            btnequals.setOnClickListener{
                if(lastnumeric){
                    val text = textarea.text.toString()
                    val expression = ExpressionBuilder(text).build() // can change the string in code
                    try {
                        val result = expression.evaluate() // run that code we change into string by using ExpressionBuilder
                        textarea.text = result.toString()
                        lastdot = true
                    }catch (ex:Exception){
                        textarea.setText("ERROR")
                        lastnumeric = false

                    }

                }
            }
        }
    }

}