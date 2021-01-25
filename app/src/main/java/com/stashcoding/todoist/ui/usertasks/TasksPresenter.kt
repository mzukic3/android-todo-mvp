package com.stashcoding.todoist.ui.usertasks

import com.stashcoding.todoist.domain.model.Task
import com.stashcoding.todoist.domain.repository.UsersRepository
import com.stashcoding.todoist.ui.base.BasePresenter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

class TasksPresenter(private val usersRepository: UsersRepository) :
    BasePresenter<TasksPresenter.View>() {

    fun onGetCompletedTasks(userId: Int) {
        view?.showLoading()
        usersRepository
            .getTasks(userId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    if (it.isEmpty())
                        view?.showNoCompletedTasks()
                    else {
                        val completedTasks = it.filter { task -> task.completed }
                        view?.showCompletedTasks(completedTasks)
                    }
                },
                {
                    view?.showError("Error while loading tasks")
                }
            )
    }

    fun onUnGetCompletedTasks(userId: Int) {
        view?.showLoading()
        usersRepository
            .getTasks(userId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    if (it.isEmpty())
                        view?.showNoCompletedTasks()
                    else {
                        val unCompletedTasks = it.filter { task -> !task.completed }
                        view?.showUnCompletedTasks(unCompletedTasks)
                    }
                },
                {
                    view?.showError("Error while loading tasks")
                }
            )
    }

    interface View {
        fun showCompletedTasks(tasks: List<Task>)
        fun showUnCompletedTasks(tasks: List<Task>)
        fun showError(errorMessage: String)
        fun showLoading()
        fun showNoCompletedTasks()
    }
}
