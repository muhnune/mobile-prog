package com.android.daracare.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.daracare.R
import com.android.daracare.data.model.User
import com.android.daracare.databinding.ActivityLoginBinding
import com.android.daracare.ui.register.RegisterActivity
import com.android.daracare.ui.main.MainActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var registeredUser: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get user from intent
        registeredUser = intent.getParcelableExtra("USER_DATA")

        binding.login.setOnClickListener {
            val email = binding.username.text.toString().trim()
            val password = binding.password.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (registeredUser != null && registeredUser?.email == email && registeredUser?.password == password) {
                val intent = Intent(this, MainActivity::class.java).apply {
                    putExtra("USER_DATA", registeredUser)
                }
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnSignup.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}
