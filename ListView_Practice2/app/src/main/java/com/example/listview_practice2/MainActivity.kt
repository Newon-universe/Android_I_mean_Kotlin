package com.example.listview_practice2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listview_practice2.databinding.ActivityMainBinding

data class BusinessCard(val name: String, val content: String)
class MainActivity : AppCompatActivity() {

    var businessCardArrayList = ArrayList<BusinessCard>()

    private lateinit var customAdapter:CustomAdapter

    lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        for (i in 0..2)
        {
            businessCardArrayList.add(BusinessCard("1", "하이"))
            businessCardArrayList.add(BusinessCard("2", "하이"))
            businessCardArrayList.add(BusinessCard("3", "하이"))
            businessCardArrayList.add(BusinessCard("4", "하이"))
        }

        customAdapter = CustomAdapter(this, businessCardArrayList)
        binding.listView.adapter=customAdapter

    }
}