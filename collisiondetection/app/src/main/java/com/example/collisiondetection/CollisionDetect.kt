package com.example.collisiondetection

import android.graphics.RectF

fun areColliding(rect: RectF, x: Float, y: Float) : Boolean =
    x >= rect.left &&
            x <= rect.right &&
            y >= rect.top &&
            y <= rect.bottom