package com.stashcoding.todoist.ui.users

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.stashcoding.todoist.R
import com.stashcoding.todoist.domain.model.User
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UsersActivity : AppCompatActivity(), UsersPresenter.View {

    @Inject
    lateinit var presenter: UsersPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun showUsers(users: List<User>) {
        TODO("Not yet implemented")
    }

    override fun showError(errorMessage: String) {
        TODO("Not yet implemented")
    }

    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun showEmptyScreen() {
        TODO("Not yet implemented")
    }
}
