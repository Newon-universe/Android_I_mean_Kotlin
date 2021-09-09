package com.example.todocompose.data.models

import com.example.todocompose.ui.theme.HighPriorityColor
import com.example.todocompose.ui.theme.LowPriorityColor
import com.example.todocompose.ui.theme.MediumPriorityColor
import com.example.todocompose.ui.theme.NonePriorityColor

enum class Priority(val color: androidx.compose.ui.graphics.Color) {
    High(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}