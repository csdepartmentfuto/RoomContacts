package com.example.android.roomcontacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android.roomcontacts.database.UserRepository
import com.example.android.roomcontacts.database.entity.UserEntity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    private lateinit var username: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var loginBtn: MaterialButton
    private lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()
    }

    private fun init() {

        loginBtn = findViewById(R.id.loginBtn)

        userRepository = UserRepository(this)


        loginBtn.setOnClickListener {
            username = findViewById(R.id.usernameEditText)
            password = findViewById(R.id.passwordEditText)

            if (username.text.isNullOrBlank() || password.text.isNullOrBlank()){
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
            } else {
                authUser()
            }
        }
    }

    private fun authUser() {

        val username = username.text.toString()
        val password = password.text.toString()

        val user = userRepository.login(username, password)

        if (user == null) {
            Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
        } else {
            showContactCategory()
        }
    }

    private fun showContactCategory() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}

