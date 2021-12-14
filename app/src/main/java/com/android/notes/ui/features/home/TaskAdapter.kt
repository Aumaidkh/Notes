package com.android.notes.ui.features.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.notes.data.db.entities.TodoItem
import com.android.notes.databinding.RvTaskItemBinding


class TaskAdapter(
    private val todoItems: List<TodoItem>
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = RvTaskItemBinding.inflate(
            LayoutInflater.from(
                parent.context
            ), parent, false
        )

        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = todoItems[position]
        holder.bindItems(task)
    }

    override fun getItemCount(): Int = todoItems.size


    inner class TaskViewHolder(private val binding: RvTaskItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindItems(todoItem: TodoItem) {
            binding.taskCheckBox.text = todoItem.task_description
            if (!todoItem.is_pending!!) binding.taskCheckBox.isChecked
        }

    }
}