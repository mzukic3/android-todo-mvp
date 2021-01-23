package com.stashcoding.todoist.data.network.api

import com.stashcoding.todoist.data.network.response.todos.TodosResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("/todos")
    fun getUserTodos(@Query("userId") userId: String): Call<TodosResponse>
}