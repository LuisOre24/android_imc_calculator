package com.sonder.imc_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    val calculateImc = findViewById<Button>(R.id.btnPlay)
    val clear = findViewById<Button>(R.id.btnClear)
    val heightPerson = findViewById<EditText>(R.id.heightInput)
    val weightPerson = findViewById<EditText>(R.id.weightInput)

    val imcMessage = findViewById<TextView>(R.id.showMessage)

    val funImc = imcCalulator()

        calculateImc.setOnClickListener {

            val heightVal = heightPerson.text.toString().toDouble()
            val weightVal = weightPerson.text.toString().toDouble()

            val resultImc = funImc.imc(weightVal, heightVal)

            val toast = Toast.makeText(this, resultImc.toString(), Toast.LENGTH_SHORT).show()

            imcMessage.text = funImc.resultText(resultImc).toString()

        }

        clear.setOnClickListener {
            clearControl()
        }

    }

    fun clearControl(){

        val heightPerson = findViewById<EditText>(R.id.heightInput)
        val weightPerson = findViewById<EditText>(R.id.weightInput)
        val imcMessage = findViewById<TextView>(R.id.showMessage)

        heightPerson.setText("")
        weightPerson.setText("")
        imcMessage.setText("")

    }

}

class imcCalulator() {

    fun imc(weight: Double, height: Double): Double {

        val imc: Double = (weight / height.pow(2))

        return String.format("%.2f", imc).toDouble()
    }

    fun resultText(result : Double) : String{

        val message : String

        if (result < 15){
            message = "Delgadez muy severa"
        }
        else if (result <= 15.9){
            message = "Delgadez Severa"
        }
        else if (result <= 18.4){
            message = "Delgadez"
        }
        else if (result <= 24.9){
            message = "Peso Saludable"
        }
        else if (result <=29.9){
            message = "Sobrepeso"
        }
        else if (result <= 34.9){
            message = "Obesidad Moderada"
        }
        else if (result <= 39.9){
            message = "Obesidad Severa"
        }
        else{
            message = "Obesidad Morbida"
        }

        return message
    }
}



