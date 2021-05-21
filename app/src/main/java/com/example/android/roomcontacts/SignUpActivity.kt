package com.example.android.roomcontacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.android.roomcontacts.database.UserRepository
import com.example.android.roomcontacts.database.entity.UserEntity

class SignUpActivity : AppCompatActivity() {

    private lateinit var username: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var signUpBtn: Button
    private lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        init()
    }

    private fun init() {

        username = findViewById(R.id.usernameEt)

        email = findViewById(R.id.emailEt)

        password = findViewById(R.id.passwordEt)

        signUpBtn = findViewById(R.id.signUpBtn)

        userRepository = UserRepository(this)

        signUpBtn.setOnClickListener {
            saveData()

        }

    }

    private fun saveData() {

        val user = UserEntity(
                userName = username.text.toString(),
                emailAddress = email.text.toString(),
                password = password.text.toString()
        )
        if (validateInput(user)) {

            userRepository.registerUser(user)

            Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validateInput(user: UserEntity): Boolean {
        var isValid = true
        if (user.userName.isEmpty() || user.emailAddress.isEmpty() || user.password.isEmpty()) {
            isValid = false
        }
        return isValid
    }

}