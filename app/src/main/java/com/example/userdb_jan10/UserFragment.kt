package com.example.userdb_jan10

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.userdb_jan10.adapter.UserAdapter
import com.example.userdb_jan10.databinding.UsersBinding
import com.example.userdb_jan10.model.local.user.User
import com.example.userdb_jan10.model.local.user.UserDatabase
import com.example.userdb_jan10.model.repository.UserRepository
import com.example.userdb_jan10.viewmodel.UserViewModel

class UserFragment : Fragment() {

    private var _binding: UsersBinding? = null
    private val binding: UsersBinding get() = _binding!!


    var ID = 0


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = UsersBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            viewModel.users.observe(viewLifecycleOwner) { users ->
                jsonRv.apply {
                    adapter = users?.let { UserAdapter(it) }
                    layoutManager =
                        LinearLayoutManager(requireContext())



                    addBtn.setOnClickListener {

                        var firstName = firstEt.text.toString()
                        var lastName = lastEt.text.toString()

                        var user = User(ID, firstName, lastName)
                        viewModel.insertUser(user)
                        ID++


                        Log.d(TAG, "this is itt -->  $user")
                    }
                }

            }

        }


    }


    private val viewModel: UserViewModel by viewModels {
        UserViewModel.Factory(
            UserRepository(
                UserDatabase.getDatabase(requireActivity().applicationContext).userDao()
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}