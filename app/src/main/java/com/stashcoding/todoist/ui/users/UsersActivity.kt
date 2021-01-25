package com.stashcoding.todoist.ui.users

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.stashcoding.todoist.R
import com.stashcoding.todoist.databinding.ActivityUsersBinding
import com.stashcoding.todoist.domain.model.User
import com.stashcoding.todoist.ui.usertasks.TasksActivity
import com.stashcoding.todoist.util.hide
import com.stashcoding.todoist.util.show
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UsersActivity : AppCompatActivity(), UsersPresenter.View {

    @Inject
    lateinit var presenter: UsersPresenter

    private lateinit var adapter: UsersAdapter
    private lateinit var binding: ActivityUsersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.adapter = UsersAdapter {
            navigateToDetails(it)
        }
        binding.recyclerView.adapter = this.adapter
    }

    override fun showUsers(users: List<User>) {
        binding.recyclerView.show()
        binding.errorText.hide()
        binding.progressBar.hide()
        binding.buttonRetry.hide()
        adapter.submitList(users)
    }

    override fun showError(errorMessage: String) {
        binding.recyclerView.hide()
        binding.errorText.show()
        binding.progressBar.hide()
        binding.buttonRetry.show()
        binding.errorText.text = errorMessage
    }

    override fun showLoading() {
        binding.recyclerView.hide()
        binding.errorText.hide()
        binding.progressBar.show()
        binding.buttonRetry.show()
    }

    override fun showEmptyScreen() {
        binding.recyclerView.hide()
        binding.errorText.show()
        binding.progressBar.hide()
        binding.buttonRetry.hide()
        binding.errorText.text = getString(R.string.no_users_found)
    }

    private fun navigateToDetails(user: User) {
        startActivity(TasksActivity.newIntent(this, user.id))
    }
}
