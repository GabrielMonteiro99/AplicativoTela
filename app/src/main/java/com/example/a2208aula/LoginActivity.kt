package com.example.a2208aula

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var btlogin: Button
    private lateinit var textusuario: EditText
    private lateinit var textsenha: EditText
    private lateinit var btfinalizar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        btlogin = findViewById(R.id.btlogin)
        textusuario = findViewById(R.id.textusuario)
        textsenha = findViewById(R.id.textsenha)
        btfinalizar = findViewById(R.id.btfinalizar)


        btfinalizar.setOnClickListener {
            var telainicio: Intent
            telainicio = Intent(this, inicioActivity::class.java)
            startActivity(telainicio)
        }

        btlogin.setOnClickListener {

            val usuariostring = textusuario.text.toString().trim()
            val senhastring = textsenha.text.toString().trim()

            val usuariocorreto = "Gabriel"
            val senhacorreta = "gabriel726"

            if (usuariostring.isNotEmpty() && senhastring.isNotEmpty())
                if (usuariostring == usuariocorreto && senhastring == senhacorreta) {
                    val login = Intent(this, EscolherActivity::class.java)
                    startActivity(login)

                } else {
                    Toast.makeText(this, "Usuário ou Senha incorreto!", Toast.LENGTH_SHORT).show()
                }
                else {
                 Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

//var telaMenu: Intent
//telaMenu = Intent(this, escolherActivity::class.java)
//startActivity(telaMenu)
