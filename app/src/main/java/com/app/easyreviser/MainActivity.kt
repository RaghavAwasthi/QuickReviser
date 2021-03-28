package com.app.easyreviser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.easyreviser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setSupportActionBar(binding.appbar)

        setContentView(binding.root)


    }
}