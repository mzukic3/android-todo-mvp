package com.stashcoding.todoist.data.network.response.todos

data class TodosResponseItem(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)