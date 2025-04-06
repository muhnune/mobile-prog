package com.android.daracare.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.daracare.data.model.User
import com.android.daracare.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<User>("USER_DATA")
        binding.welcomeUsername.text = "Welcome, ${user?.fullName ?: "Guest"}!"
    }
}
