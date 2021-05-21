package com.example.android.roomcontacts.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey


@Entity(tableName = "users")
data class UserEntity(

        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,

        @ColumnInfo(name = "userId")
        var userName: String,

        @ColumnInfo(name = "emailAddress")
        var emailAddress: String,

        @ColumnInfo(name = "password")
        var password: String
)
