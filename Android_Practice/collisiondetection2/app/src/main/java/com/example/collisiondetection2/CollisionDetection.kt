package com.example.collisiondetection2

import android.graphics.RectF

fun intersect(rect1: RectF, rect2: RectF) =
    rect1.left <= rect2.right &&
            rect1.right >= rect2.left &&
            rect1.top <= rect2.bottom &&
            rect1.bottom >= rect2.top

/*
    !(rect1.left > rect2.right) ||
        rect1.right < rect2.left ||
        rect1.top > rect2.bottom ||
        rect1.bottom < rect2.top
 */