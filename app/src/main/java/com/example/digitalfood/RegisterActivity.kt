package com.example.digitalfood

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : AppCompatActivity() {
    lateinit var arrowBack: ImageButton
    lateinit var confirm: Button
    lateinit var emailRegister: TextInputEditText
    lateinit var nome: TextInputEditText
    lateinit var passRegister: TextInputEditText
    lateinit var confirmPass: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        nome = findViewById(R.id.nome)
        emailRegister = findViewById(R.id.email_register)
        passRegister = findViewById(R.id.pass_register)
        confirmPass = findViewById(R.id.confirm_pass)
        confirm = findViewById(R.id.registerButton)
        confirm.setOnClickListener {
            val confirmButtonIntent = Intent(this,MainActivity::class.java)
            startActivity(confirmButtonIntent)
            finish()
        }
        arrowBack = findViewById(R.id.arrowback)
        arrowBack.setOnClickListener {
            val arrowIntent = Intent(this, MainActivity::class.java)
            startActivity(arrowIntent)
            finish()
        }
    }
}