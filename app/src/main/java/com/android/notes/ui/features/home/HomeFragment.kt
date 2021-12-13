package com.android.notes.ui.features.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.android.notes.R
import com.android.notes.data.db.entities.Note
import com.android.notes.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: Fragment(R.layout.fragment_home) {

    private  val TAG = "HomeFragment"

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentHomeBinding.bind(view)

        var notes : ArrayList<Note> = ArrayList()

        // Observing and adding data to the recycler view here
        homeViewModel.getNotes().observe(viewLifecycleOwner, Observer {

            notes = it as ArrayList<Note>
            val notesAdapter = NotesAdapter(){

            }
            notesAdapter.setItems(notes)

            binding.rvTodoItems.apply {
                adapter = notesAdapter
                layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            }
        })
    }


    fun addNotes(){
        Log.d(TAG, "addNotes: Adding Notes...")
        homeViewModel.createNote(Note(null,"First Note","This is the first note that is inserted"))
        homeViewModel.createNote(Note(null,"Second Note","This is the second note that is inserted"))
        homeViewModel.createNote(Note(null,"Third Note","This is the third note that is inserted"))
    }
}