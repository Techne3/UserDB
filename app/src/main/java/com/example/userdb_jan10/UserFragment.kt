package com.example.userdb_jan10

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.userdb_jan10.databinding.UsersBinding
import com.example.userdb_jan10.model.local.user.User
import com.example.userdb_jan10.model.local.user.UserDatabase
import com.example.userdb_jan10.model.repository.UserRepository
import com.example.userdb_jan10.viewmodel.UserViewModel

class UserFragment : Fragment() {

    private  var  _binding: UsersBinding? = null
    private val binding: UsersBinding get() = _binding!!


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
        with(binding){

            addBtn.setOnClickListener{

                Log.d(TAG, "this is itt -->  $it")
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


}