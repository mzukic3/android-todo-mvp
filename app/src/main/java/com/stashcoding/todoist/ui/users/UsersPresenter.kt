package com.stashcoding.todoist.ui.users

import com.stashcoding.todoist.domain.model.User
import com.stashcoding.todoist.domain.repository.UsersRepository
import com.stashcoding.todoist.ui.base.BasePresenter
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class UsersPresenter @Inject constructor(
    private val usersRepository: UsersRepository,
) : BasePresenter<UsersPresenter.View>() {

    fun loadUsers() {
        view?.showLoading()
        usersRepository
            .getUsers()
            .subscribe(
                {
                    if (it.isEmpty()) {
                        view?.showEmptyScreen()
                    } else {
                        view?.showUsers(it)
                    }
                },
                {
                    view?.showError("Something went wrong")
                }
            )
            .addToEventStream()
    }

    interface View {
        fun showUsers(users: List<User>)
        fun showError(errorMessage: String)
        fun showLoading()
        fun showEmptyScreen()
    }
}
