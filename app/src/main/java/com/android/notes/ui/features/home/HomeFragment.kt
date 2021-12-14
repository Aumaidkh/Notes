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
import com.android.notes.data.db.entities.TodoItem
import com.android.notes.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import kotlin.collections.ArrayList

@AndroidEntryPoint
class HomeFragment: Fragment(R.layout.fragment_home) {

    private  val TAG = "HomeFragment"

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentHomeBinding.bind(view)

        var notes : ArrayList<Note> = ArrayList()

       // addNotesDirectlyToRoomForTesting()

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


    //Inserting a note has to be done with a note having non null tasks value
    //decision to show checklist will be made on tasks.size
    private fun addNotesDirectlyToRoomForTesting(){
//        Log.d(TAG, "addNotes: Adding Notes...")
        val tasks = ArrayList<TodoItem>()
//        tasks.add(TodoItem(true,"Eat Food and stay fit"))
//        tasks.add(TodoItem(true,"Write article"))
//        tasks.add(TodoItem(true,"Revise Dsa"))
//
//        homeViewModel.createNote(Note(null,"First Note",null,tasks))
//        homeViewModel.createNote(Note(null,"Second Note","This is the second note that is inserted",tasks))
        homeViewModel.createNote(Note(null,"Fourth Note","This is the fourth note and it has its body that will be displayed instead of the checklist",tasks ))
    }
}