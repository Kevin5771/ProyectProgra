package com.example.proyectoprogra.Citas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectoprogra.R

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnLogout = findViewById<Button>(R.id.btn_logout)
        btnLogout.setOnClickListener{

        }

        val btnReservarCita = findViewById<Button>(R.id.btn_reservar_cita)
        btnReservarCita.setOnClickListener {

            goToCreateAppoiment()
        }

        val btnMisCitas = findViewById<Button>(R.id.btn_mis_citas)
        btnMisCitas.setOnClickListener{
            goToMyAppointments()

        }

    }

    private fun goToMyAppointments(){
        val intent = Intent(this, AppointmentsActivity::class.java)
        startActivity(intent)
    }

    private fun goToCreateAppoiment(){
        val i = Intent(this, CreateAppoiment::class.java)
        startActivity(i)
    }
}