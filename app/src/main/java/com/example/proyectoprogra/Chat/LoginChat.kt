package com.example.proyectoprogra.Chat

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectoprogra.R

class LoginChat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_chat)
        MostrarBienvenida()

        }

 fun MostrarBienvenida(){
     object: CountDownTimer(3000, 1000){
         override fun onTick(p0: Long) {
             //TODO("Not yet implemented")
         }

         override fun onFinish() {
            val intent = Intent(applicationContext, Inicio::class.java)
             startActivity(intent)
             finish()
         }

     }.start()
 }
}