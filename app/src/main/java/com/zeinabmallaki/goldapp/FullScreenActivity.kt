package com.zeinabmallaki.goldapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.zeinabmallaki.goldapp.databinding.ActivityFullScreenBinding

class FullScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFullScreenBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFullScreenBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        },1000)


    }
}