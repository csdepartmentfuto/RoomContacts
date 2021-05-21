package com.example.android.roomcontacts.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android.roomcontacts.database.dao.UsersDao
import com.example.android.roomcontacts.database.entity.UserEntity

@Database(
        entities = [UserEntity::class],
        version = 1
)

abstract class UsersDatabase: RoomDatabase() {

    abstract fun usersDao(): UsersDao

    companion object {
        @Volatile private var instance: UsersDatabase? = null
        private val LOCC = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCC){
            instance ?: buildDatabase(context)
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, UsersDatabase::class.java, "users.db").build()
    }
}