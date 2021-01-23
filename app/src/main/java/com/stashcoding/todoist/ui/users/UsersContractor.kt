package com.stashcoding.todoist.ui.users

import com.stashcoding.todoist.domain.model.User
import com.stashcoding.todoist.ui.base.BasePresenter
import com.stashcoding.todoist.ui.base.BaseView

interface UsersContractor {
    interface Presenter: BasePresenter {
        fun onLoadUsersTapped()
    }

    interface View : BaseView<Presenter> {
        fun displayUsers(users: List<User>)
    }
}