package com.stashcoding.todoist.data.repository

import com.stashcoding.todoist.data.mapper.toUsers
import com.stashcoding.todoist.data.network.api.ApiService
import com.stashcoding.todoist.domain.model.User
import com.stashcoding.todoist.domain.repository.UsersRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class UserRepositoryImpl(
    private val apiService: ApiService
) : UsersRepository {
    override fun getUsers(): Single<List<User>> =
        apiService
            .getTodos()
            .subscribeOn(Schedulers.io())
            .map {
                it.toUsers()
            }
}
