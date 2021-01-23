package com.stashcoding.todoist.ui.base

interface BaseView<T> {
    fun setPresenter(presenter : T)
}