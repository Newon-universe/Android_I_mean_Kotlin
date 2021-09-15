package com.example.collisiondetection2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.Log
import android.view.MotionEvent
import android.view.View

class CustomView(context: Context): View(context) {


    val rect1 = RectF(100f, 100f, 300f, 300f)
    val rect2 = RectF(100f, 400f, 400f, 600f)
    var selectedRect: RectF? = null

//    var collision = RectF.intersects(rect1, rect2)
    var collision = intersect(rect1, rect2)

    val paint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
        strokeWidth = 8f
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.apply{
            if(collision)
                drawColor(Color.GREEN)
            else
                drawColor(Color.BLUE)

            drawRect(rect1,paint)
            drawRect(rect2,paint)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.apply{
            when(action){
                MotionEvent.ACTION_DOWN -> {
                    selectedRect = when {
                        rect1.contains(x,y) -> rect1
                        rect2.contains(x,y) -> rect2
                        else -> null
                    }
                    Log.d("TAG", "down at $x $y")
                    return true
                }
                MotionEvent.ACTION_MOVE -> {
                    Log.d("TAG", "move at $x $y")
                    when(selectedRect){
                        rect1 -> rect1.offsetTo(x,y)
                        rect2 -> rect2.offsetTo(x,y)
                        else -> return true
                    }
                    collision = intersect(rect1, rect2)
                    invalidate()
                    return true
                }
            }
        }
        return false
    }
}