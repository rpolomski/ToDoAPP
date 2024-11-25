package com.example.todoapp.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Job(
    @PrimaryKey(autoGenerate = true) val uid: Int=0,
    @ColumnInfo(name = "Title") val title: String,
    @ColumnInfo(name = "Body") val body: String,
)