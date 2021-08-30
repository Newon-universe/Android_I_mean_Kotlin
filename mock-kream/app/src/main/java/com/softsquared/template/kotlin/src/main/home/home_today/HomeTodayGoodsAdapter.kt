package com.softsquared.template.kotlin.src.main.home.home_today

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.softsquared.template.kotlin.databinding.FragmentHomeTodayRecycleGoodsItemsBinding
import com.softsquared.template.kotlin.src.main.home.home_today.models.JustDropped

class HomeTodayGoodsAdapter(private val items: List<JustDropped>, val mainIntent:(Int) -> Unit): RecyclerView.Adapter<HomeTodayGoodsAdapter.GoodsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeTodayGoodsAdapter.GoodsHolder {
        var binding = FragmentHomeTodayRecycleGoodsItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GoodsHolder(binding)
    }

    override fun onBindViewHolder(holder: GoodsHolder, position: Int) {

        Glide.with(holder.itemView.context)
            .load(items[position].img)
            .into(holder.image)

        Glide.with(holder.itemView.context)
            .load(items[position].brandimg)
            .into(holder.brand)

        holder.title.text = items[position].name
        holder.price.text = items[position].price.toString()


        holder.itemView.setOnClickListener{
            mainIntent(items[position].idx)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


    inner class GoodsHolder(val binding: FragmentHomeTodayRecycleGoodsItemsBinding): RecyclerView.ViewHolder(binding.root){
        val image = binding.goodsViewItemImage
        val brand = binding.goodsViewItemBrand
        val title = binding.goodsViewItemName
        val price = binding.goodsViewItemPrice
    }

}