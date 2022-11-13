package com.example.task10_1.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(var name: String, var price: String, var mass: String){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
