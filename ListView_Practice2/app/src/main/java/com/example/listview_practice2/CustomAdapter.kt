package com.example.listview_practice2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.listview_practice2.databinding.ListviewItemBinding

class CustomAdapter(context: Context, private val businessCardArraylist:ArrayList<BusinessCard>): BaseAdapter(){

// 인플레이션 - context 로 받는 (from 액티비티에서)
    private val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    lateinit var binding:ListviewItemBinding


    override fun getCount(): Int = businessCardArraylist.size

    override fun getItem(indexing: Int): Any = businessCardArraylist[indexing]

    override fun getItemId(indexing: Int): Long = indexing.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        binding = ListviewItemBinding.inflate(inflater)
        binding.nameListviewItem.text=businessCardArraylist[position].name
        binding.contentListviewItem.text=businessCardArraylist[position].content



        return binding.root
    }
}