package com.stashcoding.todoist.ui.tasks

import com.stashcoding.todoist.domain.model.Task
import com.stashcoding.todoist.domain.repository.UsersRepository
import com.stashcoding.todoist.ui.base.BasePresenter
import dagger.hilt.android.scopes.ActivityScoped
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@ActivityScoped
class TasksPresenter @Inject constructor(private val usersRepository: UsersRepository) :
    BasePresenter<TasksPresenter.View>() {

    private var completedTasks: List<Task>? = null
    private var unCompletedTasks: List<Task>? = null

    fun onGetCompletedTasks(userId: Int) {
        completedTasks.let {
            if (it == null) {
                loadTasks(userId, true)
            } else {
                view?.showCompletedTasks(it)
            }
        }
    }

    fun onUnGetCompletedTasks(userId: Int) {
        unCompletedTasks.let {
            if (it == null) {
                loadTasks(userId, false)
            } else {
                view?.showUnCompletedTasks(it)
            }
        }
    }

    private fun loadTasks(userId: Int, completed: Boolean) {
        view?.showLoading()
        usersRepository
            .getTasks(userId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    if (it.isEmpty())
                        view?.showNoCompletedTasks()
                    else {
                        if (completed) {
                            val completedTasks = it.filter { task -> task.completed }
                            this.completedTasks = completedTasks
                            view?.showCompletedTasks(completedTasks)
                        } else {
                            val unCompletedTasks = it.filter { task -> !task.completed }
                            this.unCompletedTasks = unCompletedTasks
                            view?.showUnCompletedTasks(unCompletedTasks)
                        }
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
