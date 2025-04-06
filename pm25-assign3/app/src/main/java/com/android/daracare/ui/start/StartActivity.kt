package com.android.daracare.ui.start

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.view.View
import android.widget.Button
import com.android.daracare.R
import com.android.daracare.databinding.ActivityStartBinding
import com.android.daracare.ui.login.LoginActivity

class StartActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnLogin: Button = binding.button
        btnLogin.setOnClickListener(this)
    }

    override fun onClick(v: View?){
        when (v?.id){
            R.id.button -> {
                val intent = Intent(this@StartActivity, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }
}