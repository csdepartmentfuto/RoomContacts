package com.example.android.roomcontacts.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.android.roomcontacts.database.entity.UserEntity

@Dao
interface UsersDao {

    @Query("SELECT * FROM users where userId=(:userId) and password=(:password)")
    fun login(userId: String, password: String): UserEntity?

    @Insert
    fun registerUser(userEntity: UserEntity)

}