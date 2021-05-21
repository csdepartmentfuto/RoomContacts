package com.example.android.roomcontacts.database

import android.content.Context
import com.example.android.roomcontacts.database.entity.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserRepository(context: Context) {
    private val db = UsersDatabase.invoke(context)

    fun login(userId: String, password: String): UserEntity? = db.usersDao().login(userId, password)

    fun registerUser(entity: UserEntity) {
        GlobalScope.launch {
            withContext(Dispatchers.IO){
                db.usersDao().registerUser(entity)
            }
        }
    }
}