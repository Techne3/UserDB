package com.example.userdb_jan10.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.userdb_jan10.databinding.UserItemsBinding
import com.example.userdb_jan10.model.local.user.User

class UserAdapter(
    private val userList: List<User>
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    // Inflating ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = UserItemsBinding.inflate(inflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    // size of item
    override fun getItemCount(): Int {
        return userList.size
    }


    // Attaches data to xml of our item.
    class UserViewHolder(private val binding: UserItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            with(binding) {

               firstNameTv.text =  user.firstName
               lastNameTv.text =  user.lastName


            }
        }
    }
}