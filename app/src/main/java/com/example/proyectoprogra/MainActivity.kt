package com.example.proyectoprogra

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.proyectoprogra.Citas.LoginScr

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar componentes
        val textViewWelcome: TextView = findViewById(R.id.textViewWelcome)
        val buttonSchedule: Button = findViewById(R.id.buttonSchedule)
        val buttonChat: Button = findViewById(R.id.buttonChat)
        val buttonAdoption: Button = findViewById(R.id.buttonAdoption)

        // Configurar acciones para los botones
        buttonSchedule.setOnClickListener { navegarALogin() }
        buttonChat.setOnClickListener { mostrarToast("Botón 2 presionado") }
        buttonAdoption.setOnClickListener { mostrarToast("Botón 3 presionado") }
    }

    // Función para navegar al Login
    private fun navegarALogin() {
        val intent = Intent(this, LoginScr::class.java)
        startActivity(intent)
    }

   
    private fun mostrarToast(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }
}
