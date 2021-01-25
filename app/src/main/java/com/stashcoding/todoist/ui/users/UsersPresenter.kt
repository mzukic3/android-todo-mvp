package com.stashcoding.todoist.ui.users

import com.stashcoding.todoist.domain.model.User
import com.stashcoding.todoist.domain.repository.UsersRepository
import com.stashcoding.todoist.ui.base.BasePresenter
import dagger.hilt.android.scopes.ActivityRetainedScoped
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@ActivityRetainedScoped
class UsersPresenter @Inject constructor(
    private val usersRepository: UsersRepository,
) : BasePresenter<UsersPresenter.View>() {

    private var users: List<User>? = null

    fun onGetUsers() {
        users.let { users ->
            if (users == null) {
                view?.showLoading()
                usersRepository
                    .getUsers()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        {
                            this.users = it
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
            } else {
                view?.showUsers(users)
            }
        }
    }

    interface View {
        fun showUsers(users: List<User>)
        fun showError(errorMessage: String)
        fun showLoading()
        fun showEmptyScreen()
    }
}
