package com.example.calculadoraimc2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        resultTextView = findViewById(R.id.resultTextView)

        val peso = intent.getFloatExtra("peso", 0f)
        val altura = intent.getFloatExtra("altura", 0f)


        val imc = calculoIMC(peso, altura)
        val imcText = String.format("%.2f", imc)
        val classificacao = "Classificação:"


        val result = when {
            imc < 18.5 -> {
                "Abaixo do peso"
            }
            imc < 25 -> {
                "Peso normal"
            }
            imc < 30 -> {
                "Sobrepeso"
            }
            imc < 34.5 -> {
                "Obesidade Grau 1"
            }
            imc < 40 -> {
                "Obesidade Grau 2"
            }
            else -> {
                "Obesidade Grau 3"
            }

        }
        val message = "$imcText\n\n$classificacao\n\n$result"


        resultTextView.text = message
    }

    private fun calculoIMC(peso: Float, altura: Float): Float {

        val alturaEmMetros = altura / 100

        return peso / (alturaEmMetros * alturaEmMetros)
    }
}