package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // 데이터를 담을 그릇 - 배열
    var modelList = ArrayList<model>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        for (i in 1..10){
            var model = model(name = "정대리 $i", profileImage = "data:image/jpeg;base64,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")
            this.modelList.add(model)
        }



    }
}