package com.softsquared.template.kotlin.src.goods

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.databinding.ActivityGoodsMainInformationItemsBinding
import com.softsquared.template.kotlin.src.goods.models.GoodsInfo

class GoodsMainInformationAdapter(val items:List<GoodsInfo>): RecyclerView.Adapter<GoodsMainInformationAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = ActivityGoodsMainInformationItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(position){
            0 -> {
                holder.sort.text = "모델번호"
                holder.content.text = items[0].modelname
            }
            1 -> {
                holder.sort.text = "출시일"
                holder.content.text = items[0].releaseday
            }
            2 -> {
                holder.sort.text = "대표색상"
                holder.content.text = items[0].mainColor
            }
            3 -> {
                holder.sort.text = "발매가"
                holder.content.text = items[0].price.toString()
            }
        }
    }

    override fun getItemCount(): Int {
        return 4
    }


    inner class ViewHolder(val binding:ActivityGoodsMainInformationItemsBinding): RecyclerView.ViewHolder(binding.root){
        val sort = binding.goodsMainInformationSort
        val content = binding.goodsMainInformationContent
    }
}