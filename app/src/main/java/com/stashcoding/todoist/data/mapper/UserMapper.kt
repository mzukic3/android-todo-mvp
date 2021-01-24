package com.stashcoding.todoist.data.mapper

import com.stashcoding.todoist.data.network.response.todos.TodosResponse
import com.stashcoding.todoist.domain.model.Todo
import com.stashcoding.todoist.domain.model.User

fun TodosResponse.toUsers(): List<User> {
    val users = mutableMapOf<Int, MutableList<Todo>>()
    forEach {
        if (users[it.userId] == null) {
            users[it.userId] = mutableListOf()
        }
        users[it.userId]?.add(Todo(it.id, it.title))
    }
    return users.map {
        User(it.key, it.value)
    }
}
