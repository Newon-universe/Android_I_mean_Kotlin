package com.softsquared.template.kotlin.src.goods

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.databinding.ActivityGoodsMainRelatedItemsBinding

class GoodsMainRelatedListAdapter(private val items:MutableList<RelatedGoodsList>, val goodsMainIntent:(String)-> Unit): RecyclerView.Adapter<GoodsMainRelatedListAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodsMainRelatedListAdapter.Holder {
        val binding = ActivityGoodsMainRelatedItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.image.setImageResource(items[position].image.toInt())
        holder.brand.setImageResource(items[position].brand.toInt())
        holder.title.text = items[position].title
        holder.price.text = items[position].price

        holder.itemView.setOnClickListener{
            goodsMainIntent(items[position].idx)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


    inner class Holder(val binding: ActivityGoodsMainRelatedItemsBinding): RecyclerView.ViewHolder(binding.root){
        val image = binding.goodsViewItemImage
        val brand = binding.goodsViewItemBrand
        val title = binding.goodsViewItemName
        val price = binding.goodsViewItemPrice
    }
}