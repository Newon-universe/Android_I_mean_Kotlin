package com.softsquared.template.kotlin.src.goods

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.softsquared.template.kotlin.databinding.ActivityGoodsMainTopCollapsingImagesItemsBinding

class GoodsMainCollapsingAdapter(val items: List<String>): RecyclerView.Adapter<GoodsMainCollapsingAdapter.CollapsingViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollapsingViewHolder {
        var binding = ActivityGoodsMainTopCollapsingImagesItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CollapsingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CollapsingViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(items[position])
            .into(holder.goodsList)
    }

    override fun getItemCount(): Int {
        return items.size
    }


    inner class CollapsingViewHolder(val binding: ActivityGoodsMainTopCollapsingImagesItemsBinding): RecyclerView.ViewHolder(binding.root){
        val goodsList = binding.goodsMainTopCollapsingGoodsImages
    }

}