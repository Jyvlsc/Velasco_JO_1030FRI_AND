package com.ucb.midterm.bottomnavigation

import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class TodoAdapter(private val context: Context, private val todoList: ArrayList<String>) :
    ArrayAdapter<String?>(context, R.layout.list_item, todoList as List<String?>) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        if (convertView == null) {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.list_item, parent, false)
        }

        val checkBox = convertView!!.findViewById<CheckBox>(R.id.checkBox)
        val todoText = convertView.findViewById<TextView>(R.id.todoText)

        val currentTodo = todoList[position]
        todoText.text = currentTodo

        convertView.setOnClickListener { v: View? ->
            showEditDeleteDialog(position)
        }

        return convertView
    }

    private fun showEditDeleteDialog(position: Int) {
        val currentTodo = todoList[position]

        val dialogView: View = LayoutInflater.from(context).inflate(R.layout.dialog_edit_todo, null)
        val editTodoInput = dialogView.findViewById<EditText>(R.id.editTodoInput)
        editTodoInput.setText(currentTodo)

        AlertDialog.Builder(context)
            .setTitle("Edit or Delete To-Do")
            .setView(dialogView)
            .setPositiveButton("Edit") { dialog: DialogInterface?, which: Int ->
                val updatedTodo = editTodoInput.text.toString()
                if (!updatedTodo.isEmpty()) {
                    todoList[position] = updatedTodo
                    notifyDataSetChanged()
                }
            }
            .setNegativeButton("Delete") { dialog: DialogInterface?, which: Int ->
                todoList.removeAt(position)
                notifyDataSetChanged()
            }
            .setNeutralButton("Cancel", null)
            .show()
    }
}