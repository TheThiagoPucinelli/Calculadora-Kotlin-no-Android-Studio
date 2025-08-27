package com.example.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var textNumero1: EditText
    private lateinit var textNumero2: EditText

    private lateinit var btnSomar: Button
    private lateinit var btnSub: Button
    private lateinit var btnMultiplicar: Button
    private lateinit var btnDividir: Button

    private lateinit var labelResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textNumero1 = findViewById(R.id.textNumero1)
        textNumero2 = findViewById(R.id.textNumero2)

        btnSomar = findViewById(R.id.btnSomar)
        btnSub = findViewById(R.id.btnSub)
        btnMultiplicar = findViewById(R.id.btnMultiplicar)
        btnDividir = findViewById(R.id.btnDividir)

        labelResultado = findViewById(R.id.labelResultado)

        btnSomar.setOnClickListener {
            val number1 = textNumero1.text.toString().toDouble()
            val number2 = textNumero2.text.toString().toDouble()
            val resultado = number1 + number2
            labelResultado.text = "Resultado: $resultado"
        }

        btnSub.setOnClickListener {
            val number1 = textNumero1.text.toString().toDouble()
            val number2 = textNumero2.text.toString().toDouble()
            val resultado = number1 - number2
            labelResultado.text = "Resultado: $resultado"
        }

        btnMultiplicar.setOnClickListener {
            val number1 = textNumero1.text.toString().toDouble()
            val number2 = textNumero2.text.toString().toDouble()
            val resultado = number1 * number2
            labelResultado.text = "Resultado: $resultado"
        }

        btnDividir.setOnClickListener {
            val number1 = textNumero1.text.toString().toDouble()
            val number2 = textNumero2.text.toString().toDouble()
            if (number2 != 0.0) {
                val resultado = number1 / number2
                labelResultado.text = "Resultado: $resultado"
            } else {
                labelResultado.text = "Erro: Divisão por zero"
            }
        }
    }
}
