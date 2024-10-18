package com.example.proyectoprogra.Citas

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoprogra.R

class AppointmentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointments)

        val rvAppointments = findViewById<RecyclerView>(R.id.rv_appointments)

        val appointments = ArrayList<Appointment>()
        appointments.add(
            Appointment(1, "Doctor Kevin", "12/12/2024", "9:30 AM")
        )
        appointments.add(
            Appointment(2, "Doctor Melvin", "11/11/2024", "10:30 AM")
        )
        appointments.add(
            Appointment(3, "Doctor Cris", "10/10/2024", "11:30 AM")
        )

        rvAppointments.layoutManager = LinearLayoutManager(this)
        rvAppointments.adapter = AppointmentAdapter(appointments)
        }
    }
