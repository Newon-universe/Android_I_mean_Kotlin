package com.example.recyclerview_practice101

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Switch
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_practice101.databinding.RecycleItemBinding

class MyAdapter: RecyclerView.Adapter<Holder>() {

    var listData = mutableListOf<Member>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        var binding = RecycleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)

    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        var member = listData[position]
        holder.setData(member, position)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

}

class Holder(val binding: RecycleItemBinding): RecyclerView.ViewHolder(binding.root) {

    private val mainActivity = MainActivity.getInstance()
    var mMember: Member? = null
    var mPosition: Int? = null

    init {
        binding.btnDelete.setOnClickListener {
            mainActivity?.deleteMember(mMember!!)
        }

        binding.btnEdit.setOnClickListener {
            mainActivity?.editMember(mPosition!!, mMember!!)
        }
    }

    fun setData(member: Member, position: Int){
        with(binding){
            name.text = member.name
            introduce.text = member.introduce
            check.isChecked = member.checkStatus

            check.setOnClickListener {
                mMember!!.checkStatus = check.isChecked
            }
        }
        this.mMember = member
        this.mPosition = position
    }

}