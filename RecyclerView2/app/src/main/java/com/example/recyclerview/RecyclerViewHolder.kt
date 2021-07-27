package com.example.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerview.databinding.ActivityMainBinding
import com.example.recyclerview.databinding.LayoutRecyclerItemBinding

class RecyclerViewHolder(private val binding: LayoutRecyclerItemBinding):RecyclerView.ViewHolder(itemView) {

    private val userNameTextView = binding.userNameTxt
    private val profileImageView = binding.profileImg

    fun bind(model: model){
        userNameTextView.text = model.name

        Glide
            .with(app.instance)
            .load(model.profileImage)
//            .centerCrop()
            .placeholder(R.mipmap.ic_launcher)
            .into(profileImageView)
    }

}