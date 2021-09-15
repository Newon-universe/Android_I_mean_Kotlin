package com.softsquared.template.kotlin.src.login.sign_up

import android.app.Dialog
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.databinding.FragmentSignupShoesSizeRecyclerviewItemsBinding

class SignUpBottomSheetAdapter (private val items: MutableList<String>, val dialog: Dialog?, var sizeFix:(String)-> Unit): RecyclerView.Adapter<SignUpBottomSheetAdapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = FragmentSignupShoesSizeRecyclerviewItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.text.text = items[position]


        holder.itemView.setOnClickListener{
            sizeFix(items[position])
            dialog?.dismiss()
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }



    inner class Holder(val binding: FragmentSignupShoesSizeRecyclerviewItemsBinding):RecyclerView.ViewHolder(binding.root){
        val container = binding.signupSizeCheckerBtn
        val text = binding.signupSizeCheckerTv

    }

}