package com.example.task10_1.room

import androidx.lifecycle.LiveData

class UserRepository(var dataBase: DbConnection) {

    var users: LiveData<List<User>> = dataBase.userDao().getAll()

    fun getAll(): LiveData<List<User>>{
        return users
    }

    suspend fun insert(user: User){
        dataBase.userDao().insert(user)
    }

    suspend fun delete(user: User){
        dataBase.userDao().delete(user)
    }

}