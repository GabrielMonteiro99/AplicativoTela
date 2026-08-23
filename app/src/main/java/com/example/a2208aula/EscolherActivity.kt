package com.example.a2208aula

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EscolherActivity : AppCompatActivity() {

    private lateinit var imLogo: ImageView
    private lateinit var btimc: Button
    private lateinit var btmedia: Button
    private lateinit var btfinalizar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_escolher)

        imLogo = findViewById(R.id.imLogo)
        btimc = findViewById(R.id.btimc)
        btmedia = findViewById(R.id.btmedia)
        btfinalizar = findViewById(R.id.btfinalizar)

        imLogo.setOnClickListener {
            var telainicio: Intent
            telainicio = Intent(this, inicioActivity::class.java)
            startActivity(telainicio)
        }

        btimc.setOnClickListener {
            var telaimc: Intent
            telaimc = Intent(this, actitivyimc::class.java)
            startActivity(telaimc)
        }

        btmedia.setOnClickListener {
            var telamedia: Intent
            telamedia = Intent(this, Activitymedia::class.java)
            startActivity(telamedia)
        }

        btfinalizar.setOnClickListener {
            var telafinalizar: Intent
            telafinalizar = Intent(this, LoginActivity::class.java)
            startActivity(telafinalizar)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}