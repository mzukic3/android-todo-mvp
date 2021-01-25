package com.stashcoding.todoist.ui.usertasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stashcoding.todoist.R
import com.stashcoding.todoist.domain.model.Task

class TasksAdapter() :
    ListAdapter<Task, TasksAdapter.ViewHolder>(UserCallback) {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val taskIdTextView = itemView.findViewById<TextView>(R.id.task_id)
        private val taskTitleTextView = itemView.findViewById<TextView>(R.id.task_title)

        fun bind(task: Task) {
            taskIdTextView.text = "User ID: ${task.id}"
            taskTitleTextView.text = "Title: ${task.title}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    companion object {
        private object UserCallback : DiffUtil.ItemCallback<Task>() {
            override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
                return oldItem.title == newItem.title
            }
        }
    }
}
