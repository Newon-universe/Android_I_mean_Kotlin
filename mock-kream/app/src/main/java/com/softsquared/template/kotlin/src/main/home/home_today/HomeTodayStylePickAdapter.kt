package com.softsquared.template.kotlin.src.main.home.home_today

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.softsquared.template.kotlin.databinding.FragmentHomeTodayRecycleStylePicksItemsBinding
import com.softsquared.template.kotlin.src.main.home.home_today.models.Style

class HomeTodayStylePickAdapter(val items: List<Style>): RecyclerView.Adapter<HomeTodayStylePickAdapter.StylePickHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StylePickHolder {
        var binding = FragmentHomeTodayRecycleStylePicksItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StylePickHolder(binding)
    }

    override fun onBindViewHolder(holder: StylePickHolder, position: Int) {

        Glide.with(holder.itemView.context)
            .load(items[position].mainimg)
            .into(holder.stylePick)

        Glide.with(holder.itemView.context)
            .load(items[position].userimg)
            .into(holder.styleUser)

        holder.userName.text = items[position].profileName
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class StylePickHolder(val binding: FragmentHomeTodayRecycleStylePicksItemsBinding): RecyclerView.ViewHolder(binding.root){
        val stylePick = binding.homeTodayStylePicksImage
        val styleUser = binding.homeTodayStylePicksUserProfile
        val userName = binding.homeTodayStylePicksUserName
    }
}