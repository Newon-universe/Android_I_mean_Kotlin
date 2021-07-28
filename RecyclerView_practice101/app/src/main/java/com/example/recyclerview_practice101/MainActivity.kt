package com.example.recyclerview_practice101

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview_practice101.databinding.ActivityMainBinding
import com.example.recyclerview_practice101.databinding.AlertdialogEdittextBinding

data class Member(val name:String, var introduce:String, var checkStatus: Boolean = false)

class MainActivity : AppCompatActivity() {

    private var adapter: MyAdapter? = null
    private val data:MutableList<Member> = mutableListOf()
    var i = 4

    init{
        instance = this
    }

    companion object{
        private var instance:MainActivity? = null
        fun getInstance(): MainActivity?{
            return instance
        }
    }

    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialize()
        adapter = MyAdapter()
        adapter!!.listData = data
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.fab.setOnClickListener {
            val string = "Member$i"
            data.add(Member(string, "안뇽 ^-^ $i"), )
            i++
            adapter?.notifyDataSetChanged()
        }
    }

    private fun initialize(){
        with(data){
            add(Member("Member1", "안뇽 ^-^ 1"))
            add(Member("Member2", "안뇽 ^-^ 2"))
            add(Member("Member3", "안뇽 ^-^ 3"))
        }
    }

//    private fun refreshRecyclerView(){
//        val adapter = MyAdapter()
//        adapter.listData = data
//        binding.recyclerView.adapter = adapter
//        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//    }

    fun deleteMember(member:Member){
        data.remove(member)
        adapter?.notifyDataSetChanged()
    }

    fun editMember(position: Int, member:Member){

        val builder = AlertDialog.Builder(this)
        val builderItem = AlertdialogEdittextBinding.inflate(layoutInflater)
        val editText = builderItem.editText

        with(builder){
            setTitle("Input Introduce")
            setMessage("소개글을 입력하세요")
            setView(builderItem.root)
            setPositiveButton("OK"){_:DialogInterface,_:Int ->
                if(editText.text.toString() != null){
                    member.introduce = editText.text.toString()
                    data[position] = member
                    adapter!!.notifyDataSetChanged()
                }
            }
            show()
        }
    }
}