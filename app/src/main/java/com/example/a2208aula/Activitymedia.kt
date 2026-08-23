package com.example.a2208aula

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activitymedia : AppCompatActivity() {

    private lateinit var atv: EditText
    private lateinit var p1: EditText
    private lateinit var p2: EditText
    private lateinit var p3: EditText
    private lateinit var btcalcular: Button
    private lateinit var media: TextView
    private lateinit var btvoltar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_media)

        atv = findViewById(R.id.atv)
        p1 = findViewById(R.id.p1)
        p2 = findViewById(R.id.p2)
        p3 = findViewById(R.id.p3)
        btcalcular = findViewById(R.id.btcalcular)
        media = findViewById(R.id.media)
        btvoltar = findViewById(R.id.btvoltar)

        btvoltar.setOnClickListener {
            var telaescolher: Intent
            telaescolher = Intent(this, EscolherActivity::class.java)
            startActivity (telaescolher)
        }

        p3.isEnabled = false

        btcalcular.setOnClickListener {
            val atvstring = atv.text.toString().trim()
            val p1string = p1.text.toString().trim()
            val p2string = p2.text.toString().trim()
            val p3string = p3.text.toString().trim()

            if (atvstring.isNotEmpty() && p1string.isNotEmpty() && p2string.isNotEmpty()) {
                val atvNum = atvstring.toDoubleOrNull()
                var p1Num = p1string.toDoubleOrNull()
                var p2Num = p2string.toDoubleOrNull()
                val p3Num = p3string.toDoubleOrNull()

                if (atvNum != null && p1Num != null && p2Num != null) {
                    val resultadomedia = (atvNum * 0.2) + (p1Num * 0.4) + (p2Num * 0.4)

                    if (resultadomedia < 6) {
                        p3.isEnabled = true
                        if (p3Num != null) {
                            if (p1Num <= p2Num) {
                                if (p3Num > p1Num) p1Num = p3Num
                            } else {
                                if (p3Num > p2Num) p2Num = p3Num
                            }
                            var resultadomedia = (atvNum * 0.2) + (p1Num * 0.4) + (p2Num * 0.4)
                            val mediafinal =
                                if (resultadomedia >= 6) "Aprovado na P3" else "Reprovado"
                            media.text =
                                String.format("Média final: %.2f\n%s", resultadomedia, mediafinal)
                        } else {
                            media.text = String.format("Média: %.2f (Reprovado)\nDigite a nota da P3 para recalcular.",resultadomedia)
                        }
                    } else {
                        p3.isEnabled = false
                        p3.text.clear()
                        media.text = String.format("Média do aluno: %.2f\nAprovado", resultadomedia)
                    }
                } else {
                        media.text = "Valores Inválidos!"
                    }
            }
                    else{
                        media.text = "Preencha todos os campos!"
                    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                        val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                        v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                        )
                        insets
                    }
                }
            }
        }
    }



//val classificacao = when {
    //resultadomedia < 6 -> "Reprovado"
    //else -> "Aprovado"
//}
//media.text = String.format("E média do Aluno é: %.2f\n%s", media, classificacao)
//}else {
    //media.text = "Valores inválidos!"
//}
//} else {
  //  media.text = "Preencha todos os campos!"

//}