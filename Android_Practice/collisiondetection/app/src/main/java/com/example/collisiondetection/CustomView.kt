package com.example.collisiondetection

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.Log
import android.view.MotionEvent
import android.view.View

class CustomView(context: Context): View(context) {

    override fun onDraw(canvas: Canvas?) {
        canvas?.apply{
            if(collision)
                drawColor(Color.GREEN)
            else
                drawColor(Color.BLUE)

            drawRect(rect, paint)
        }
    }

    var rect = RectF(
        100f, //left
        100f, //top
        500f, //right
        500f // bottom
    )

    val paint = Paint().apply{
        color = Color.BLACK
        style = Paint.Style.STROKE
        strokeWidth = 4f
    }

    var collision = false

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.apply {
            when(action){
                MotionEvent.ACTION_DOWN -> {
//                    collision = rect.contains(x,y)
                    collision = areColliding(rect, x,y)
                    invalidate()
                    Log.d("TAG", "down at $x $y")
                    return true
                }
                MotionEvent.ACTION_MOVE -> {
                    Log.d("TAG", "move at $x $y")
                    return true
                }
            }
        }
        return false
    }
}