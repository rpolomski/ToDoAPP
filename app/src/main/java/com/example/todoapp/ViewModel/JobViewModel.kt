package com.example.todoapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.Database.Job
import com.example.todoapp.Database.JobRepository
import com.example.todoapp.Database.JobsDao
import kotlinx.coroutines.launch

class JobViewModel(private val repository: JobRepository) : ViewModel() {

    val jobs: LiveData<List<Job>> = repository.allJobs

    fun addTask(job: Job) {
        viewModelScope.launch {
            repository.insert(job)
        }
    }

    fun deleteJob(job: Job) {
        viewModelScope.launch {
            repository.delete(job)
        }
    }
}
