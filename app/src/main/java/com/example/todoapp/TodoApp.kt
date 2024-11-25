package com.example.todoapp

import android.app.Application
import com.example.todoapp.Database.AppDatabase
import com.example.todoapp.Database.JobRepository

class TodoApp : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { JobRepository(database.jobDao()) }
}
