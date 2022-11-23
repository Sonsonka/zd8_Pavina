package com.example.zd8_pavina_ind

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner

class ToDoListActivity : AppCompatActivity() {
    lateinit var listTask: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_list)
        listTask = findViewById(R.id.listtask)

        var pref = this.getSharedPreferences("json", MODE_PRIVATE)
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, 4, android.R.layout.simple_list_item_1, pref)
        //listTask.setAdapter(adapter)

    }
}