package com.example.task10_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.room.Room
import com.example.task10_1.databinding.FragmentCreateBinding
import com.example.task10_1.room.DbConnection
import com.example.task10_1.room.User
import com.example.task10_1.room.UserRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class CreateFragment : Fragment() {

    private lateinit var binding: FragmentCreateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bSave.setOnClickListener {
            var name = binding.edName.text.toString()
            var price = binding.edPrice.text.toString()
            var mass = binding.edMass.text.toString()


            val db = Room.databaseBuilder(requireContext(), DbConnection::class.java, "name").build()
            val repository = UserRepository(db)

            GlobalScope.launch {
                repository.insert(User(name, price, mass))
            }

            Navigation.findNavController(it).navigate(R.id.action_createFragment_to_listFragment)
        }

    }

}