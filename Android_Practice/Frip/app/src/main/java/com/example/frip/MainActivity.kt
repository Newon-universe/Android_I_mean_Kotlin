package com.example.frip

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //액션바 대신 툴바를 사용하도록 설정한다.
//        val toolbar = findViewById(R.id.toolbar) as Toolbar
//        setSupportActionBar(toolbar)
//        val ab = supportActionBar!!
//        ab.setDisplayShowTitleEnabled(false)

    }
}