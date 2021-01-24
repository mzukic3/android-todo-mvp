package com.stashcoding.todoist.domain.repository

import com.stashcoding.todoist.domain.model.User
import io.reactivex.rxjava3.core.Single

interface UsersRepository {
    fun getUsers(): Single<List<User>>
}
