package com.stashcoding.todoist.data.network.api

import com.stashcoding.todoist.data.network.response.todos.TodosResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ApiService {
    @GET("/todos")
    fun getTodos(): Single<TodosResponse>
}
