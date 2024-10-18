package com.example.proyectoprogra.Chat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectoprogra.R

class Inicio : AppCompatActivity() {

    private lateinit var Btn_Login: Button
    private lateinit var Btn_Register: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio)

        Btn_Login = findViewById(R.id.Btn_Login)
        Btn_Register = findViewById(R.id.Btn_Registro)

        Btn_Register.setOnClickListener{
            val intent = Intent(this,RegistroActivity::class.java)
            Toast.makeText(applicationContext,"Regsitros",Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

        Btn_Login.setOnClickListener{
            val intent = Intent(this,LoginScreen::class.java)
            Toast.makeText(applicationContext,"Login",Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

    }
}