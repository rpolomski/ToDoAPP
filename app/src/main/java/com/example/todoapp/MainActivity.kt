package com.example.todoapp

import JobAdapter
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.Database.Job
import com.example.todoapp.Database.JobsDao
import com.example.todoapp.ViewModel.JobViewModel
import com.example.todoapp.ViewModel.JobViewModelFactory
import com.example.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val jobViewModel: JobViewModel by viewModels {
        JobViewModelFactory((application as TodoApp).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = JobAdapter{ job ->
            jobViewModel.deleteJob(job)
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        jobViewModel.jobs.observe(this, Observer { jobs ->
            jobs?.let { adapter.submitList(it) }
        })

        binding.addTaskButton.setOnClickListener {
            val title = binding.titleEditText.text.toString().trim()
            val body = binding.bodyEditText.text.toString().trim()

            if (title.isNotEmpty() && body.isNotEmpty()) {
                val job = Job(uid = 0, title = title, body = body)
                jobViewModel.addTask(job)
                binding.titleEditText.text.clear()
                binding.bodyEditText.text.clear()
            }
        }
    }
}
