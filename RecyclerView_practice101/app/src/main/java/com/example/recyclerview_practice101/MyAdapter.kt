package com.example.recyclerview_practice101

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_practice101.databinding.ActivityMainBinding
import com.example.recyclerview_practice101.databinding.RecycleItemBinding
import com.google.android.material.snackbar.Snackbar
import java.util.*

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

    // 뷰홀더 포지션을 받아 그 위치의 데이터를 삭제하고 notifyItemRemoved 로 어댑터에 갱신 명
    fun removeData(position: Int) {
        listData.removeAt(position)
        notifyItemRemoved(position)
    }

    // 두 개의 뷰홀더 포지션을 받아 Collections.swap 으로 첫번째 위치와 두번째 위의 데이터 교환
    fun swapData(fromPos: Int, toPos: Int){
        Collections.swap(listData, fromPos, toPos)
        notifyItemMoved(fromPos, toPos)
    }



}

class Holder(val binding: RecycleItemBinding): RecyclerView.ViewHolder(binding.root) {

    private val mainActivity = MainActivity.getInstance()
    var mMember: Member? = null
    var mPosition: Int? = null

    init {
        binding.btnEdit.setOnClickListener {
            mainActivity?.editMember(mPosition!!, mMember!!)
        }
    }

    fun setData(member: Member, position: Int){
        with(binding){
            title.text = member.title
            content.text = member.content
            check.isChecked = member.checkStatus
            time.text = member.time

            check.setOnClickListener {
                mMember!!.checkStatus = check.isChecked
            }

            recycleViewItemLayout.setOnClickListener {
                check.isChecked = !check.isChecked
                mMember!!.checkStatus = check.isChecked
                Snackbar.make(it, "오늘의 ${layoutPosition+1}번째 목표가 선택되었습니다.", Snackbar.LENGTH_SHORT).show()
            }

            binding.profile.setOnClickListener(){
                profile.playAnimation()
            }

        }
        this.mMember = member
        this.mPosition = position
    }

}