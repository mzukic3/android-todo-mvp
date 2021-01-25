package com.stashcoding.todoist.ui.users

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stashcoding.todoist.R
import com.stashcoding.todoist.domain.model.User

class UsersAdapter(private val onUserClicked: (user: User) -> Unit) :
    ListAdapter<User, UsersAdapter.ViewHolder>(UserCallback) {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userIdTextView = itemView.findViewById<TextView>(R.id.userId)
        private val unCompletedTasksTextView =
            itemView.findViewById<TextView>(R.id.uncompleted_tasks)

        fun bind(user: User) {
            userIdTextView.text = "User ID: ${user.id}"
            val numberOfTasks = user.tasks.count { task -> !task.completed }
            unCompletedTasksTextView.text = "Number of uncompleted tasks: $numberOfTasks"
            itemView.setOnClickListener {
                onUserClicked(user)
            }
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
        private object UserCallback : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.tasks == newItem.tasks
            }
        }
    }
}
