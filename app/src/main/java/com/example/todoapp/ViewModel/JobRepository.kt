package com.example.todoapp.Database

import androidx.lifecycle.LiveData

class JobRepository(private val jobsDao: JobsDao) {

    val allJobs: LiveData<List<Job>> = jobsDao.getAllLiveData()

    suspend fun insert(job: Job) {
        jobsDao.insertAll(job)
    }

    suspend fun delete(job: Job) {
        jobsDao.delete(job)
    }
}
