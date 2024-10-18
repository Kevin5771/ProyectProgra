package com.example.proyectoprogra

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.proyectoprogra.Chat.LoginChat
import com.example.proyectoprogra.Citas.LoginScr
import com.example.proyectoprogra.Citas.Menu

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
        buttonSchedule.setOnClickListener { ReservarCitas() }
        buttonChat.setOnClickListener { navegarChat()}
        buttonAdoption.setOnClickListener { mostrarToast("Botón 3 presionado") }
    }

    // Función para navegar al Login
    private fun ReservarCitas() {
        val intent = Intent(this, Menu::class.java)
        startActivity(intent)
    }
    private fun navegarChat() {
        val intent = Intent(this, LoginChat::class.java)
        startActivity(intent)
    }
    private fun mostrarToast(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }
}
