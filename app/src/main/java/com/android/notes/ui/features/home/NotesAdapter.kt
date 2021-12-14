package com.android.notes.ui.features.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool
import androidx.recyclerview.widget.LinearLayoutManager
import android.content.Context
import androidx.core.view.isVisible
import com.android.notes.data.db.entities.Note
import com.android.notes.databinding.RvTodoItemBinding


class NotesAdapter(
    private val listener: (Note) -> Unit
): RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    private var todoItems: ArrayList<Note> = ArrayList()

    // An object of RecyclerView.RecycledViewPool
    // is created to share the Views
    // between the child and
    // the parent RecyclerViews
    private val viewpool = RecycledViewPool()
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val binding = RvTodoItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        val notesViewHolder = NotesViewHolder(binding)

        context = parent.context

        return notesViewHolder
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val item = todoItems[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            item?.let { it -> listener.invoke(it) }
        }
    }

    override fun getItemCount(): Int = todoItems.size

    fun setItems(notes: ArrayList<Note>) {
        this.todoItems = notes
        notifyDataSetChanged()
    }

    inner class NotesViewHolder(private val binding: RvTodoItemBinding): RecyclerView.ViewHolder(binding.root){

        val rv_task = binding.rvTaskItems

        fun bind(item: Note){
            if(item.tasks?.isNotEmpty() == true){
                //hiding the edit text
                binding.etBody.isVisible = false
                // Create a layout manager
                // to assign a layout
                // to the RecyclerView.
                val tasklayoutmanager = LinearLayoutManager(context)
                // Since this is a nested layout, so
                // to define how many child items
                // should be prefetched when the
                // child RecyclerView is nested
                // inside the parent RecyclerView,
                // we use the following method
                tasklayoutmanager.initialPrefetchItemCount = item.tasks?.size ?: 0

                // Create an instance of the child
                // item view adapter and set its
                // adapter, layout manager and RecyclerViewPool
                val taskAdapter = item.tasks?.let { TaskAdapter(it) }

                binding.rvTaskItems.apply {
                    adapter = taskAdapter
                    layoutManager = tasklayoutmanager
                    setRecycledViewPool(viewpool)
                }
            }else {
                //Showing Body of the Note
                binding.etBody.setText(item.note_body)

            }

        }
    }
}