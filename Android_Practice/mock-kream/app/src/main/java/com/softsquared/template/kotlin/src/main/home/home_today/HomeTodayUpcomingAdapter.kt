package com.softsquared.template.kotlin.src.main.home.home_today

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.databinding.FragmentHomeTodayRecycleUpcomingItemsBinding

class HomeTodayUpcomingAdapter(val items: MutableList<UpcomingGoodsList>): RecyclerView.Adapter<HomeTodayUpcomingAdapter.UpcomingGoodsHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingGoodsHolder {
        var binding = FragmentHomeTodayRecycleUpcomingItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UpcomingGoodsHolder(binding)
    }

    override fun onBindViewHolder(holder: UpcomingGoodsHolder, position: Int) {
        holder.image.setImageResource(items[position].image.toInt())
        holder.brand.setImageResource(items[position].brand.toInt())
        holder.title.text = items[position].title
    }

    override fun getItemCount(): Int {
        return items.size
    }




    inner class UpcomingGoodsHolder(val binding:FragmentHomeTodayRecycleUpcomingItemsBinding):RecyclerView.ViewHolder(binding.root){
        val image = binding.goodsViewItemImage
        val brand = binding.goodsViewItemBrand
        val title = binding.goodsViewItemName
    }
}