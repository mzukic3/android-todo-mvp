package com.stashcoding.todoist.data.network.api

import com.stashcoding.todoist.data.network.response.todos.TodosResponse
import com.stashcoding.todoist.data.network.response.todos.TodosResponseItem
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/todos")
    fun getAllTasks(): Single<TodosResponse>

    @GET("/todos")
    fun getUserTasks(@Query("userId") userId: Int): Single<List<TodosResponseItem>>
}
