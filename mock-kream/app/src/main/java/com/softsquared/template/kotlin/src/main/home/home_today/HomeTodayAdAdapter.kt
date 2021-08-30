package com.softsquared.template.kotlin.src.main.home.home_today

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.softsquared.template.kotlin.databinding.FragmentHomeTodayAdItemBinding
import com.softsquared.template.kotlin.src.main.home.home_today.models.Mainslider

class HomeTodayAdAdapter(adList: List<Mainslider>): RecyclerView.Adapter<HomeTodayAdAdapter.PagerViewHolder>() {

    var item = adList

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeTodayAdAdapter.PagerViewHolder {
        var binding = FragmentHomeTodayAdItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PagerViewHolder(binding)
    }


    override fun onBindViewHolder(holder: HomeTodayAdAdapter.PagerViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(item[position].img)
            .into(holder.ad)
    }


    override fun getItemCount(): Int {
        return item.size
    }


    inner class PagerViewHolder(val binding: FragmentHomeTodayAdItemBinding) : RecyclerView.ViewHolder(binding.root){
        val ad = binding.homeMainTodayAdItemImageView
    }

}