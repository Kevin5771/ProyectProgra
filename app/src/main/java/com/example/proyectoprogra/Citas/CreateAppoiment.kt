package com.example.proyectoprogra.Citas

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectoprogra.R

class CreateAppoiment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_create_appoiment)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets




        }


        val btnNext = findViewById<Button>(R.id.btn_siguiente)
        val btnConfirm = findViewById<Button>(R.id.btn_Confirmar)
        val cvNext = findViewById<Button>(R.id.cv_Siguiente)
        val cvConfirm = findViewById<Button>(R.id.cv_Confirmar)


        btnNext.setOnClickListener {
            cvNext.visibility = View.GONE
            cvConfirm.visibility = View.VISIBLE
        }
        btnConfirm.setOnClickListener{
            Toast.makeText(applicationContext, "Cita Realizada Exitosamente", Toast.LENGTH_SHORT).show()
            finish()
        }

        val spinnerSpecialties = findViewById<Spinner>(R.id.spinner_especialidades)
        val spinnerDoctor = findViewById<Spinner>(R.id.spinner_medico)


        val optionSpecialtiels = arrayOf("Especialidad 1", "Especialidad 2", "Especialidad 3")
        spinnerSpecialties.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, optionSpecialtiels)


        val optionsDoctor = arrayOf("Medico 1", "Medico 2", "Medico 3")
        spinnerDoctor.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, optionsDoctor)
    }
}