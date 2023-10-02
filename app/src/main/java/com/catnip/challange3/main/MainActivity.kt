package com.catnip.challange3.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.catnip.challange3.R
import com.catnip.challange3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}