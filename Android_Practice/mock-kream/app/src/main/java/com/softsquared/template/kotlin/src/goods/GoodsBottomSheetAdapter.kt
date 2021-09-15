package com.softsquared.template.kotlin.src.goods

import android.app.Dialog
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.databinding.FragmentGoodsMainBuySellRecyclerviewItmesBinding


class GoodsBottomSheetAdapter(private val items: MutableList<GoodsBottomSheetInformation>, var goodsMainSizePrice:(MutableList<String>) -> Unit, private val dialog:Dialog?):RecyclerView.Adapter<GoodsBottomSheetAdapter.Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        var binding = FragmentGoodsMainBuySellRecyclerviewItmesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.size.setText(items[position].size)
        holder.price.setText(items[position].price)


        val list:MutableList<String> = mutableListOf()


        holder.itemView.setOnClickListener{
            list.add(items[position].size)
            list.add(items[position].price)
            goodsMainSizePrice(list)
            dialog?.dismiss()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


    inner class Holder(val binding:FragmentGoodsMainBuySellRecyclerviewItmesBinding):RecyclerView.ViewHolder(binding.root){
        val container = binding.goodsBottomRecyclerContainer
        val size = binding.goodsBottomRecyclerSizeTv
        val price = binding.goodsBottomRecyclerPriceTv



    }
}