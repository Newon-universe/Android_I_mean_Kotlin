package com.example.listview_practice1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class UserAdapter (val context: Context, val UserList: ArrayList<User>) : BaseAdapter()
{
    override fun getCount(): Int {
        return UserList.size
    }

    override fun getItem(position: Int): Any {
        return UserList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    // view 변수는 View 의 형태인데, Layoutinflater할거고, 각각의 layoutt 은 R.layout.list_item_user 로 해
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.list_item_user, null)

        val profile = view.findViewById<ImageView>(R.id.profile)
        val name = view.findViewById<TextView>(R.id.userId)
        val greet = view.findViewById<TextView>(R.id.userGreet)
        val age = view.findViewById<TextView>(R.id.userAge)

        val user = UserList[position]

        profile.setImageResource(user.profile)
        name.text = user.name
        age.text = user.age
        greet.text = user.greet

        return view
    }







}