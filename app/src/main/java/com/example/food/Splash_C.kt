package com.example.food

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class Splash_C : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_c)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this,StarActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}