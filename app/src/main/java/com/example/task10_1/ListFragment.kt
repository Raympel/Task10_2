package com.example.task10_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.CoroutinesRoom
import androidx.room.Room
import com.example.task10_1.databinding.FragmentListBinding
import com.example.task10_1.databinding.UserItemBinding
import com.example.task10_1.room.DbConnection
import com.example.task10_1.room.UserRepository


class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = Room.databaseBuilder(requireContext(), DbConnection::class.java, "name").build()
        val repository = UserRepository(db)
        val adapter = UserListAdapter()

        repository.users.observe(viewLifecycleOwner){
            adapter.updateList(it)
        }

        binding.userListRecyclerView.adapter = adapter

    }


}