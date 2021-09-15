package com.example.listview_practice2

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.LinearLayout

class customLayout(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    override fun checkLayoutParams(p: ViewGroup.LayoutParams?): Boolean {
        return super.checkLayoutParams(p)
    }
}