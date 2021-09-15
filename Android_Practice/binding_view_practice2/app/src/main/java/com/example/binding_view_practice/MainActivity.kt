package com.example.binding_view_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.binding_view_practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.Secrete.visibility
    }
}