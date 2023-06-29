package com.example.calculadoraimc2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var pesoEditText: EditText
    private lateinit var alturaEditText: EditText
    private lateinit var calcularButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pesoEditText = findViewById(R.id.pesoEditText)
        alturaEditText = findViewById(R.id.alturaEditText)
        calcularButton = findViewById(R.id.calcularButton)

        calcularButton.setOnClickListener {

            val stringPeso = pesoEditText.text.toString()
            val stringAltura = alturaEditText.text.toString()

            if (stringPeso.isNotEmpty() && stringAltura.isNotEmpty()) {

                val floatPeso: Float = stringPeso.toFloat()
                val floatAltura: Float = stringAltura.toFloat()

                val intent = Intent(this@MainActivity, MainActivity2::class.java)
                intent.putExtra("peso", floatPeso)
                intent.putExtra("altura", floatAltura)
                startActivity(intent)

            } else {

                Toast.makeText(this, "Por Favor, preencha todos os dados", Toast.LENGTH_SHORT).show()
            }
        }
    }
}