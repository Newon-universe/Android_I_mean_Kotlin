package com.example.todocompose.navigation

import androidx.navigation.NavHostController
import com.example.todocompose.util.Action

class Screens(navController: NavHostController) {
    val list: (Action) -> Unit = { action ->
        navController.navigate("list/${action.name}")
    }
}