package com.example.todoapp.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface JobsDao {
    @Query("SELECT * FROM job")
    fun getAllLiveData(): LiveData<List<Job>>

    @Insert
    suspend fun insertAll(vararg jobs: Job)

    @Delete
    suspend fun delete(job: Job)

    companion object {
        fun delete(job: Job) {

        }
    }
}
