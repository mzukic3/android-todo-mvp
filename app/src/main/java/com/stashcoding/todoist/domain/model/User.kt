package com.stashcoding.todoist.domain.model

data class User(
    val id: String,
    val todos: List<Todo>
)
