package com.stashcoding.todoist.data.network.api

import com.stashcoding.todoist.data.network.response.todos.TasksResponseItem
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/todos")
    fun getAllTasks(): Single<List<TasksResponseItem>>

    @GET("/todos")
    fun getUserTasks(@Query("userId") userId: Int): Single<List<TasksResponseItem>>
}
