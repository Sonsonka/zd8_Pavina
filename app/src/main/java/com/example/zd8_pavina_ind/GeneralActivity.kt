package com.example.zd8_pavina_ind

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class GeneralActivity : AppCompatActivity() {
    lateinit var addButton: Button
    lateinit var listButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_general)
        addButton = findViewById(R.id.button_add)
        listButton = findViewById(R.id.list)

        addButton.setOnClickListener{
                var intent = Intent(this, AddTaskActivity::class.java)
            startActivity(intent)
        }
        listButton.setOnClickListener{
            var intent = Intent(this, ToDoListActivity::class.java)
            startActivity(intent)
        }
    }
}