package com.android.hellothere

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.hellothere.databinding.ActivityMainBinding
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnHello.setOnClickListener {
            val str : String = binding.inHello.text.toString()
            if(str.isBlank()){
                binding.tvHello.setText("Looks like you forgot to enter your name")
                binding.tvHello.setTextColor(ContextCompat.getColor(this, R.color.error))
            } else {
                binding.tvHello.setText("Hello, $str")
                binding.tvHello.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
        }

    }


}

