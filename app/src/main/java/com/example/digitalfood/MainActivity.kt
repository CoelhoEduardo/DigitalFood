package com.example.digitalfood

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private val emailLiveData = MutableLiveData<String>()
    private val passwordLiveData = MutableLiveData<String>()
    private val isValidLiveData = MediatorLiveData<Boolean>().apply {
        this.value = false

        addSource(emailLiveData) { email ->
            val password = passwordLiveData.value
            this.value = validateForm(email, password)
        }
        addSource(passwordLiveData) { password ->
            val email = emailLiveData.value
            this.value = validateForm(email, password)
        }
    }


    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailLayout = findViewById<TextInputEditText>(R.id.emailText)
        emailLayout.doOnTextChanged { text, _, _, _ ->
            emailLiveData.value = text?.toString()
        }

        val passwordLayout = findViewById<TextInputEditText>(R.id.passText)
        passwordLayout.doOnTextChanged { text, _, _, _ ->
            passwordLiveData.value = text?.toString()
        }

        val register = findViewById<Button>(R.id.registerButton)
        register.setOnClickListener {
            val registerIntent = Intent(this,RegisterActivity::class.java)
            startActivity(registerIntent)
            finish()
        }

        val login = findViewById<Button>(R.id.LoginButton)
        login.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }


        isValidLiveData.observe(this) {isValid ->
            login.isEnabled = isValid
        }


    }

    private fun validateForm(email: String?, password: String?) : Boolean {
        val isValidEmail = email != null && email.isNotBlank() && email.contains("@") && email.contains(".")
        val isValidPassword = password != null && password.isNotBlank() && password.length > 4

        return isValidEmail && isValidPassword
    }
}