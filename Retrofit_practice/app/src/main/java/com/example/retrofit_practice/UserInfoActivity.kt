package com.example.retrofit_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.retrofit_practice.databinding.ActivityUserInfoBinding

class UserInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityUserInfoBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val userIntent = intent

        binding.userId.text = userIntent.getStringExtra("summonerName")
        val puuid = userIntent.getStringExtra("puuid")

    }
}