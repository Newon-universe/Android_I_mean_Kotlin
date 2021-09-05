package com.softsquared.template.kotlin.src.main.home.home_today

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.databinding.FragmentHomeTodayRecycleGoodsItemsBinding

class HomeTodayGoodsOthersAdapter(private val items: MutableList<GoodsOthersList>, val mainIntent:(Int) -> Unit): RecyclerView.Adapter<HomeTodayGoodsOthersAdapter.GoodsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodsHolder {
        var binding = FragmentHomeTodayRecycleGoodsItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GoodsHolder(binding)
    }

    override fun onBindViewHolder(holder: GoodsHolder, position: Int) {
        holder.image.setImageResource(items[position].image.toInt())
        holder.brand.setImageResource(items[position].brand!!.toInt())
        holder.title.text = items[position].title
        holder.price.text = items[position].price

        holder.itemView.setOnClickListener{
            mainIntent(items[position].title.toInt())
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