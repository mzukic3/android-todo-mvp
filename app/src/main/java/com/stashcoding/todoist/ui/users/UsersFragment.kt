package com.stashcoding.todoist.ui.users

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.stashcoding.todoist.R
import com.stashcoding.todoist.domain.model.User

class UsersFragment : Fragment(), UsersContractor.View {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_users, container, false)
    }

    override fun displayUsers(users: List<User>) {
        TODO("Not yet implemented")
    }

    override fun setPresenter(presenter: UsersContractor.Presenter) {
        TODO("Not yet implemented")
    }

}