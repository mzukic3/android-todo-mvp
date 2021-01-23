package com.stashcoding.todoist.domain.repository

import com.stashcoding.todoist.domain.model.User

interface UsersRepository {
    fun getUsers(): List<User>
}