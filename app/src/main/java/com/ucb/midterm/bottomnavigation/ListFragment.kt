package com.ucb.midterm.todolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.ucb.midterm.bottomnavigation.R
import com.ucb.midterm.bottomnavigation.TodoAdapter

class ListFragment : Fragment() {

    private var todoList: ArrayList<String>? = null
    private var adapter: TodoAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        // Initialize list and adapter
        todoList = ArrayList()
        val todoListView = view.findViewById<ListView>(R.id.todoListView)
        val todoInput = view.findViewById<EditText>(R.id.todoInput)
        val addButton = view.findViewById<Button>(R.id.addButton)

        adapter = TodoAdapter(requireContext(), todoList!!)
        todoListView.adapter = adapter

        // Add button click listener
        addButton.setOnClickListener {
            val todo = todoInput.text.toString()
            if (todo.isNotEmpty()) {
                todoList!!.add(todo)
                adapter!!.notifyDataSetChanged()
                todoInput.setText("")
            }
        }

        return view
    }
}
