package com.example.proyectoprogra.Citas

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View

import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectoprogra.R
import com.google.android.material.snackbar.Snackbar
import java.time.Year
import java.util.Calendar

class CreateAppoiment : AppCompatActivity() {
    private val selectedCalendar = Calendar.getInstance()
    private var selectedRadioButton: RadioButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_create_appoiment)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.linearLayout_create_appointment)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val btnNext = findViewById<Button>(R.id.btn_siguiente)
        val btnNext2 = findViewById<Button>(R.id.btn_siguiente_dos)
        val btnConfirm = findViewById<Button>(R.id.btn_Confirmar)

        val cvNext = findViewById<CardView>(R.id.cv_Siguiente)
        val cvConfirm = findViewById<CardView>(R.id.cv_Confirmar)
        val cvResumen = findViewById<CardView>(R.id.cv_resumen)

        val etDescription = findViewById<EditText>(R.id.et_description)
        val etScheduledDate = findViewById<EditText>(R.id.et_fecha)

        val linearLayoutCreateAppoiment = findViewById<LinearLayout>(R.id.linearLayout_create_appointment)

        btnNext.setOnClickListener {
            if(etDescription.text.toString().length < 3){
                etDescription.error = "La descripcion es demasiada corta"
            }else {
                cvNext.visibility = View.GONE
                cvConfirm.visibility = View.VISIBLE
            }

        }
        btnNext2.setOnClickListener{
            if(etScheduledDate.text.toString().isEmpty()){
                etScheduledDate.error = ""
                Snackbar.make(linearLayoutCreateAppoiment, "Debe escoger una fecha para las citas", Snackbar.LENGTH_SHORT).show()
            }else if (selectedRadioButton == null){
                Snackbar.make(linearLayoutCreateAppoiment, "Debe seleccionar una hora para la cita", Snackbar.LENGTH_SHORT).show()

            }else{
                showAppointmentDataToConfirm()
                cvConfirm.visibility = View.GONE
                cvResumen.visibility = View.VISIBLE
            }

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

    private fun showAppointmentDataToConfirm(){
        val tvConfirmDescription = findViewById<TextView>(R.id.tv_resumen_sintomas)
        val tvConfirmSpecialty = findViewById<TextView>(R.id.tv_resumen_especialidad)
        val tvConfirmType = findViewById<TextView>(R.id.tv_resumen_tipoConsulta)
        val tvConfirmDoctorName = findViewById<TextView>(R.id.tv_resumen_medico)
        val tvConfirmDate = findViewById<TextView>(R.id.tv_resumen_fecha)
        val tvConfirmTime = findViewById<TextView>(R.id.tv_resumen_hora)

        val etDescription = findViewById<EditText>(R.id.et_description)
        val spinnerSpecialties = findViewById<Spinner>(R.id.spinner_especialidades)
        val radioGroupType = findViewById<RadioGroup>(R.id.radio_group_type)
        val spinnerDoctor = findViewById<Spinner>(R.id.spinner_medico)
        val etScheduledDate = findViewById<EditText>(R.id.et_fecha)

        tvConfirmDescription.text = etDescription.text.toString()
        tvConfirmSpecialty.text = spinnerSpecialties.selectedItem.toString()

        val selectRadioBtnId = radioGroupType.checkedRadioButtonId
        val selectedRadioType = radioGroupType.findViewById<RadioButton>(selectRadioBtnId)
        tvConfirmType.text = selectedRadioType.text.toString()

        tvConfirmDoctorName.text = spinnerDoctor.selectedItem.toString()
        tvConfirmDate.text = etScheduledDate.text.toString()
        tvConfirmTime.text = selectedRadioButton?.text.toString()


    }

    fun onClickScheduleDate(v: View?){
        val etSchedulDate = findViewById<EditText>(R.id.et_fecha)

        val year = selectedCalendar.get(Calendar.YEAR)
        val month = selectedCalendar.get(Calendar.MONTH)
        val dayOfMonth = selectedCalendar.get(Calendar.DAY_OF_MONTH)
        val listener = android.app.DatePickerDialog.OnDateSetListener{ datePicker, Y, M, D ->
            selectedCalendar.set(Y, M, D)
            etSchedulDate.setText(resources.getString(R.string.date_format,
                Y,
                (M+1).twoDigits(),
                D.twoDigits()))

            etSchedulDate.error = null
            displayRadioButtons()
        }

        val datePickerDialog = DatePickerDialog(this, listener, year, month, dayOfMonth )
        val datePicker = datePickerDialog.datePicker
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_MONTH, 1)
        datePicker.minDate = calendar.timeInMillis
        calendar.add(Calendar.DAY_OF_MONTH, 29)
        datePicker.maxDate = calendar.timeInMillis
        datePickerDialog.show()

    }

    private fun Int.twoDigits()
        = if(this > 10) this.toString() else "0$this"

    private fun displayRadioButtons(){
        val radioGroupLeft = findViewById<LinearLayout>(R.id.radio_group_izq)
        val radioGroupRight = findViewById<LinearLayout>(R.id.radio_group_der)

        radioGroupLeft.removeAllViews()
        radioGroupRight.removeAllViews()

        selectedRadioButton = null


        var goToLeft = true

        val hours = arrayOf(" 8:00 Am", " 8:30 AM", "9:00 AM", "9:30 AM", "10 AM")
        hours.forEach {
            val radioButton = RadioButton(this)
            radioButton.id = View.generateViewId()
            radioButton.text = it

            radioButton.setOnClickListener{View ->
                selectedRadioButton?.isChecked = false
                selectedRadioButton = View as RadioButton?
                selectedRadioButton?.isChecked = true
            }

            if (goToLeft)
                radioGroupLeft.addView(radioButton)
            else
                radioGroupRight.addView(radioButton)
            goToLeft = !goToLeft
        }

    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {

        val cvNext = findViewById<CardView>(R.id.cv_Siguiente)
        val cvConfirm = findViewById<CardView>(R.id.cv_Confirmar)
        val cvResumen = findViewById<CardView>(R.id.cv_resumen)

        if(cvResumen.visibility == View.VISIBLE){
            cvResumen.visibility = View.GONE
            cvConfirm.visibility = View.VISIBLE
        }else if (cvConfirm.visibility == View.VISIBLE){
            cvConfirm.visibility = View.GONE
            cvNext.visibility = View.VISIBLE
        }else if (cvNext.visibility == View.VISIBLE){
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Estas seguro que desea salir?")
            builder.setMessage("Si abandonas el registro, los datos ingresados se perderan")
            builder.setPositiveButton("Salir"){_, _ ->
                finish()
            }
            builder.setNegativeButton("Continuar"){dialog, which ->
                dialog.dismiss()
            }
            val dialog = builder.create()
            dialog.show()
        }





    }
}