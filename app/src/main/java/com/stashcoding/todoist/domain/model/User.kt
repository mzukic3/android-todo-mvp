package com.stashcoding.todoist.domain.model

data class User(
    val id: Int,
    val todos: List<Todo>
)
