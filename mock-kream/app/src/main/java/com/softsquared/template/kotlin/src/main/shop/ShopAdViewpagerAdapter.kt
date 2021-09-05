package com.softsquared.template.kotlin.src.main.shop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.softsquared.template.kotlin.databinding.FragmentShopAdViewpagerItemsBinding

class ShopAdViewpagerAdapter(val items: List<String>):RecyclerView.Adapter<ShopAdViewpagerAdapter.PagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        var binding = FragmentShopAdViewpagerItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(items[position%items.size])
            .into(holder.ad)
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

    inner class PagerViewHolder(val binding: FragmentShopAdViewpagerItemsBinding) : RecyclerView.ViewHolder(binding.root){
        val ad = binding.shopAdItemImageView
    }

}