package com.example.todoapp.ViewModel

import JobAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Delete

import com.example.todoapp.Database.JobsDao
import com.example.todoapp.R

class JobFragment : Fragment() {
    private val jobViewModel: JobViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_job, container, false)

        // RecyclerView setup
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = JobAdapter { job ->
            jobViewModel.deleteJob(job) // Usuwanie klikniętego elementu
        }

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        // Obserwowanie LiveData
        jobViewModel.jobs.observe(viewLifecycleOwner) { jobs ->
            adapter.submitList(jobs)
        }

        return view
    }
}