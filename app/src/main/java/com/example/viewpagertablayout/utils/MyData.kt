package com.example.viewpagertablayout.utils

import com.example.viewpagertablayout.R
import com.example.viewpagertablayout.models.User

object MyData {
    val list=ArrayList<User>()

    fun addUser(){
        list.add(User("BMW", R.drawable.img))
        list.add(User("BMW", R.drawable.img_1))
        list.add(User("BMW", R.drawable.img_2))
    }
}