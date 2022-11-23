package com.example.zd8_pavina_ind

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class EditTaskActivity : AppCompatActivity() {
    lateinit var backbutt2: Button
    lateinit var editButton: Button
    lateinit var deleteButton: Button
    lateinit var zagTask2: EditText
    lateinit var timeTask2: EditText
    lateinit var dateTask2: EditText
    lateinit var descriptTask2: EditText
    lateinit var vazhTask2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_task)

        backbutt2 = findViewById(R.id.button_back2)
        editButton = findViewById(R.id.edit_button)
        deleteButton = findViewById(R.id.delete_button)
        zagTask2 = findViewById(R.id.zag_act2)
        timeTask2 = findViewById(R.id.time_act2)
        dateTask2 = findViewById(R.id.date_act2)
        descriptTask2 = findViewById(R.id.description_act2)
        vazhTask2 = findViewById(R.id.vazhnost_act2)



        backbutt2.setOnClickListener {
            var intent = Intent(this, ToDoListActivity::class.java)
            startActivity(intent)
        }
    }
}