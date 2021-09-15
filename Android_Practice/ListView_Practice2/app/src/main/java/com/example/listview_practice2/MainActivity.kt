package com.example.listview_practice2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
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

        businessCardArrayList.add(BusinessCard("1", "하이"))
        businessCardArrayList.add(BusinessCard("2", "하이"))
        businessCardArrayList.add(BusinessCard("3", "하이"))
        businessCardArrayList.add(BusinessCard("4", "하이"))

        customAdapter = CustomAdapter(this, businessCardArrayList)
        binding.listView.adapter=customAdapter

        binding.listView.
    }

    override fun onResume() {
        super.onResume()
        binding.add.setOnClickListener(){

            businessCardArrayList.add(BusinessCard(binding.add.text.toString(), "하이"))
            customAdapter.notifyDataSetChanged()
        }

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener{parent, view, position, id ->
            val selectItem = parent.getItemAtPosition(position) as BusinessCard
            var selectedItemId = parent.getItemIdAtPosition(position)
            Toast.makeText(this, selectItem.name, Toast.LENGTH_LONG).show()

            Log.d("IEQ", "$selectItem")
            Log.d("IEQ", "$selectedItemId")
        }

    }
}