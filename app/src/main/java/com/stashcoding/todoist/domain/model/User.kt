package com.stashcoding.todoist.domain.model

data class User(
    val id: Int,
    val tasks: List<Task>
)
