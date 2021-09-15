package com.example.listview_practice1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.listview_practice1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    var userList = arrayListOf<User>(
        User(R.drawable.ic_robot,"뉴원","28","안녕하세요"),
        User(R.drawable.ic_robot,"다현","22","트와이스!"),
        User(R.drawable.ic_robot,"아린","20","오마이걸"),
        User(R.drawable.ic_robot,"승희","21","오마이거거걸"),
        User(R.drawable.ic_robot,"비니","24","안녕 :)"),
        User(R.drawable.ic_robot,"지호","23","나도 안녕:)"),
        User(R.drawable.ic_robot,"효정","25","ㅎㅎ")
    )

    // 액티비티 실행 시작 지점
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val item = arrayOf("사과", "배", "딸기", "키위", "아린", "다현")
//
//        // context 란 한 액티비티의 모든 정보를 담고 있다.
//        // simple_list_item_1 은 리스트 형태
//        // item 은 array list
//        binding.ListView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, item)

        val Adapter = UserAdapter(this, userList)
        binding.ListView.adapter = Adapter


    }
}