package com.stashcoding.todoist.ui.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stashcoding.todoist.databinding.ItemUserBinding
import com.stashcoding.todoist.domain.model.User

class UsersAdapter(private val onUserClicked: (user: User) -> Unit) :
    ListAdapter<User, UsersAdapter.ViewHolder>(UserCallback) {

    inner class ViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            binding.userId.text = "User ID: ${user.id}"
            val numberOfTasks = user.tasks.count { task -> !task.completed }
            binding.uncompletedTasks.text = "Number of uncompleted tasks: $numberOfTasks"
            itemView.setOnClickListener {
                onUserClicked(user)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
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
