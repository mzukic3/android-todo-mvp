package com.stashcoding.todoist.data.repository

import com.stashcoding.todoist.data.mapper.toTask
import com.stashcoding.todoist.data.mapper.toUsers
import com.stashcoding.todoist.data.network.api.ApiService
import com.stashcoding.todoist.domain.model.Task
import com.stashcoding.todoist.domain.model.User
import com.stashcoding.todoist.domain.repository.UsersRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class UserRepositoryImpl constructor(
    private val apiService: ApiService
) : UsersRepository {
    override fun getUsers(): Single<List<User>> =
        apiService
            .getAllTasks()
            .subscribeOn(Schedulers.io())
            .map {
                it.toUsers()
            }

    override fun getTasks(userId: Int): Single<List<Task>> {
        return apiService
            .getUserTasks(userId)
            .subscribeOn(Schedulers.io())
            .toFlowable()
            .flatMapIterable { item -> item }
            .map { it.toTask() }
            .toList()
    }
}
