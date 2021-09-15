package com.example.recyclerview_practice101

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_practice101.databinding.ActivityMainBinding
import com.example.recyclerview_practice101.databinding.AlertdialogEdittextBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


// **sponser boolean array**
data class Member(var title:String, var content:String = "", var time: String = "", var checkStatus: Boolean = false)

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MyAdapter
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


    // 시간
    val current = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("HH:mm")
    val formatted: String = current.format(formatter)

    // 정렬 기준
    var descendingSort = false


    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        initialize()
        adapter = MyAdapter()
        adapter.listData = data
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.fab.setOnClickListener {
            createMember(this.data)
//            val string = "Member$i"
//            data.add(Member(string, "안뇽 ^-^ $i"),)
//            i++
            adapter.notifyDataSetChanged()
        }

        binding.btnSort.setOnClickListener {
            if (descendingSort == false) {
                data.sortByDescending(Member::time)
                descendingSort = true
            } else {
                data.sortBy(Member::time)
                descendingSort = false
            }

            adapter.notifyDataSetChanged()
        }

        val itemTouchCallback = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN, ItemTouchHelper.LEFT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val fromPos = viewHolder.adapterPosition
                val toPos = target.adapterPosition
                adapter.swapData(fromPos, toPos)
                // 움직이는 포지션은 adapterPosition
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                adapter.removeData(viewHolder.layoutPosition)
                // 고정된 포지션은 layoutPosition
            }

        }
        ItemTouchHelper(itemTouchCallback).attachToRecyclerView(binding.recyclerView)

        // **text watcher**  or filter ?
    }

    private fun initialize(){
        with(data){
            add(Member("밥먹기", "팔도비빔면에 삼겹살", formatted))
            add(Member("청소하기", "선풍기 닦기", formatted))
            add(Member("고양이", "나만 고양이 없어 |나만 고양이 없어 |나만 고양이 없어 |나만 고양이 없어 |나만 고양이 없어 |", formatted))
        }
    }

//    private fun refreshRecyclerView(){
//        val adapter = MyAdapter()
//        adapter.listData = data
//        binding.recyclerView.adapter = adapter
//        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//    }

//    fun deleteMember(member:Member){
//        data.remove(member)
//        adapter?.notifyDataSetChanged()
//    }

    private fun createMember(member: MutableList<Member>){

        val builder = AlertDialog.Builder(this)
        val builderItem = AlertdialogEdittextBinding.inflate(layoutInflater)
        val editText = builderItem.editText

        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("HH:mm")
        val formatted: String = current.format(formatter)

        with(builder){
            setTitle("오늘의 할 일은 무엇인가요?")
            setMessage("제목을 입력하세요")
            setView(builderItem.root)
            setPositiveButton("OK"){_:DialogInterface,_:Int ->
                if(editText.text.toString() != null){
                    data.add(Member(editText.text.toString(), "", formatted) )
                    adapter.notifyDataSetChanged()
                }
            }
            show()
        }
    }


    fun editMember(position: Int, member:Member){

        val builder = AlertDialog.Builder(this)
        val builderItem = AlertdialogEdittextBinding.inflate(layoutInflater)
        val editText = builderItem.editText

        with(builder){
            setTitle("오늘의 할 일은 무엇인가요?")
            setMessage("세부 사항을 입력하세요")
            setView(builderItem.root)
            setPositiveButton("OK"){_:DialogInterface,_:Int ->
                    member.content = editText.text.toString()
                    data[position] = member
                    adapter.notifyDataSetChanged()
            }
            show()
        }
    }
}