package com.ucb.midterm.todolist

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var todoList: ArrayList<String>? = null
    private var adapter: TodoAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoList = ArrayList()
        val todoListView = findViewById<ListView>(R.id.todoListView)
        val todoInput = findViewById<EditText>(R.id.todoInput)
        val addButton = findViewById<Button>(R.id.addButton)

        adapter = TodoAdapter(this, todoList!!)
        todoListView.adapter = adapter

        addButton.setOnClickListener { view: View? ->
            val todo = todoInput.text.toString()
            if (!todo.isEmpty()) {
                todoList!!.add(todo)
                adapter!!.notifyDataSetChanged()
                todoInput.setText("")
            }
        }
    }
}