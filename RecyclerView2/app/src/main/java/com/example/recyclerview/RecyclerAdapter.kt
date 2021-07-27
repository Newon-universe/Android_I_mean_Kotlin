package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.LayoutRecyclerItemBinding

class RecyclerAdapter: RecyclerView.Adapter<RecyclerViewHolder>() {

    private var modelList = ArrayList<model>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_recycler_item, parent))
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 5
    }

    fun submitList(model)

}