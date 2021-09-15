package com.softsquared.template.kotlin.src.goods.goods_like_bottomsheet

import android.app.Dialog
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.databinding.FragmentGoodsMainLikeRecyclerviewItemsBinding
import com.softsquared.template.kotlin.src.goods.goods_like_bottomsheet.models.Result

class GoodsLikeBottomSheetAdapter(private val items:MutableList<GoodsLikeBottomSheetInformation>, val postLike:(Int) -> Unit, val patchLike:(Int) -> Unit, val likedSize:List<Result>): RecyclerView.Adapter<GoodsLikeBottomSheetAdapter.Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = FragmentGoodsMainLikeRecyclerviewItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.size.text = items[position].size

        if(items[position].interest)
            holder.like.isChecked = true

        holder.itemView.setOnClickListener {
            holder.like.isChecked = !holder.like.isChecked
            if(holder.like.isChecked){
                postLike(items[position].size.toInt())
            }
            else if(!holder.like.isChecked){
                patchLike(items[position].size.toInt())
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }


    inner class Holder(val binding: FragmentGoodsMainLikeRecyclerviewItemsBinding):RecyclerView.ViewHolder(binding.root){
        val size = binding.goodsMainLikeSizeTv
        val like = binding.goodsMainLikeIcon
    }

}