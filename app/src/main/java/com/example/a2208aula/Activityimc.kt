package com.example.a2208aula

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class actitivyimc : AppCompatActivity() {

    private lateinit var btcalcular: Button
    private lateinit var btpeso: EditText
    private lateinit var btaltura: EditText
    private lateinit var resultado: TextView
    private lateinit var btvoltar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc)

        btpeso = findViewById(R.id.btpeso)
        btaltura = findViewById(R.id.btaltura)
        btcalcular = findViewById(R.id.btcalcular)
        resultado = findViewById(R.id.resultado)
        btvoltar = findViewById(R.id.btvoltar)

        btvoltar.setOnClickListener {
            var telaescolher: Intent
            telaescolher = Intent(this, EscolherActivity::class.java)
            startActivity (telaescolher)
        }

        btcalcular.setOnClickListener {
            val pesoString = btpeso.text.toString().trim()
            val alturaString = btaltura.text.toString().trim()

            if (pesoString.isNotEmpty() && alturaString.isNotEmpty()) {
                val peso = pesoString.toDoubleOrNull()
                val altura = alturaString.toDoubleOrNull()

                if (peso != null && altura != null && altura > 0.0) {
                    val imc = peso / (altura * altura)

                    val classificacao = when {
                        imc < 18.5 -> "Abaixo do peso"
                        imc < 24.9 -> "Peso normal"
                        imc < 29.9 -> "Sobrepeso"
                        imc < 34.9 -> "Obesidade Grau I"
                        imc < 39.9 -> "Obesidade Grau II"
                        else -> "Obesidade Grau III (mórbida)"
                    }
                    resultado.text = String.format("IMC: %.2f\n%s", imc, classificacao)
                } else {
                    resultado.text = "Valores inválidos!"
                }
            } else {
                resultado.text = "Preencha todos os campos!"
            }
        }
    }
}
