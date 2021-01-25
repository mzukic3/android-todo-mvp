package com.stashcoding.todoist.data.mapper

import com.stashcoding.todoist.data.network.response.todos.TasksResponseItem
import com.stashcoding.todoist.domain.model.Task
import com.stashcoding.todoist.domain.model.User

fun List<TasksResponseItem>.toUsers(): List<User> {
    val users = mutableMapOf<Int, MutableList<Task>>()
    forEach {
        it.userId?.let { userId ->
            if (users[userId] == null) {
                users[userId] = mutableListOf()
            }
            users[userId]?.add(it.toTask())
        }
    }
    return users.map {
        User(it.key, it.value)
    }
}

fun TasksResponseItem.toTask(): Task {
    return Task(this.id ?: 0, this.title ?: "", this.completed ?: false)
}
