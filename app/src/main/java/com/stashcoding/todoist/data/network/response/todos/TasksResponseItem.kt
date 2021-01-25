package com.stashcoding.todoist.data.network.response.todos


import com.google.gson.annotations.SerializedName

data class TasksResponseItem(
    @SerializedName("completed")
    val completed: Boolean? = false,
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("userId")
    val userId: Int? = 0
)