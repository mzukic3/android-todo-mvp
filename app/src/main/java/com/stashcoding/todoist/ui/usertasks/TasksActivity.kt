package com.stashcoding.todoist.ui.usertasks

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.stashcoding.todoist.R
import com.stashcoding.todoist.databinding.ActivityTasksBinding
import com.stashcoding.todoist.domain.model.Task
import com.stashcoding.todoist.util.hide
import com.stashcoding.todoist.util.show
import javax.inject.Inject

class TasksActivity : AppCompatActivity(), TasksPresenter.View {

    @Inject
    lateinit var presenter: TasksPresenter

    private lateinit var binding: ActivityTasksBinding
    private lateinit var adapter: TasksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTasksBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val userId = intent.getIntExtra(USER_ID, 0)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@TasksActivity.adapter
        }
        binding.tabLayout.addOnTabSelectedListener(
            object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    if (tab?.position == 0) {
                        presenter.onGetCompletedTasks(userId)
                    } else {
                        presenter.onUnGetCompletedTasks(userId)
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
//
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
//
                }
            }
        )
    }

    override fun showCompletedTasks(tasks: List<Task>) {
        binding.recyclerView.show()
        binding.errorText.hide()
        binding.progressBar.hide()
        binding.buttonRetry.hide()
        adapter.submitList(tasks)
    }

    override fun showUnCompletedTasks(tasks: List<Task>) {
        binding.recyclerView.show()
        binding.errorText.hide()
        binding.progressBar.hide()
        binding.buttonRetry.hide()
        adapter.submitList(tasks)
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

    override fun showNoCompletedTasks() {
        binding.recyclerView.hide()
        binding.errorText.show()
        binding.progressBar.hide()
        binding.buttonRetry.hide()
        binding.errorText.text = getString(R.string.no_users_found)
    }

    companion object {
        private const val USER_ID = "USER_ID"
        fun newIntent(context: Context, userId: Int): Intent {
            val intent = Intent(context, TasksActivity::class.java)
            intent.putExtra(USER_ID, userId)
            return intent
        }
    }
}
