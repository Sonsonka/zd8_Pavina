package com.example.zd8_pavina_ind

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject

class AddTaskActivity : AppCompatActivity() {
    lateinit var backbutt: Button
    lateinit var addButton: Button
    lateinit var titleTask: EditText
    lateinit var timeTask: EditText
    lateinit var dateTask: EditText
    lateinit var descriptTask: EditText
    lateinit var priorTask: EditText
    var indexNow: Int = 0
    lateinit  var prefEditor: SharedPreferences.Editor
    lateinit var prefs: SharedPreferences
    var hasvisited: Boolean? = null
    val json = """
        {"title" "time" "data" "desription" "priority"}
    """.trimIndent()
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)
        backbutt = findViewById(R.id.button_back)
        addButton = findViewById(R.id.zap_button)
        titleTask = findViewById(R.id.zag_act)
        timeTask = findViewById(R.id.time_act)
        dateTask = findViewById(R.id.date_act)
        descriptTask = findViewById(R.id.description_act)
        priorTask = findViewById(R.id.vazhnost_act)
        prefs = getSharedPreferences("title", Context.MODE_PRIVATE)
        prefs = getSharedPreferences("time", Context.MODE_PRIVATE)
        prefs = getSharedPreferences("date", Context.MODE_PRIVATE)
        prefs = getSharedPreferences("descript", Context.MODE_PRIVATE)
        prefs = getSharedPreferences("priority", Context.MODE_PRIVATE)
        hasvisited = prefs.getBoolean("hasVisited", false)
        if(hasvisited == false)
        {
            val x: SharedPreferences.Editor = prefs.edit()
            x.putBoolean("hasVisited", true)
            x.apply()
            addButton.visibility = View.INVISIBLE
        }
        else {
            addButton.visibility = View.VISIBLE
        }

        backbutt.setOnClickListener{
            var intent = Intent(this@AddTaskActivity, GeneralActivity::class.java )
            startActivity(intent)
        }

        addButton.setOnClickListener {
            val tasks = Gson().fromJson<List<Task>>(json, object: TypeToken<List<Task>>(){}.type)
            val listtasks: String = Gson().toJson(tasks)
            var x: String = Gson().toJson(it)
            var prefEditor = prefs.edit()
            prefEditor.putString("json", x)
            prefEditor.apply()
            var getx = prefs.getString("json", "noData")
            if(titleTask.text.toString().isNotEmpty() || timeTask.text.toString().isNotEmpty() || dateTask.text.toString().isNotEmpty() || descriptTask.text.toString().isNotEmpty() || priorTask.text.toString().isNotEmpty()){
                val toast = Toast.makeText(applicationContext, "Данные сохранены!", Toast.LENGTH_SHORT)
                toast.show()

                val intent = Intent(this, GeneralActivity::class.java)
                startActivity(intent)

            }
            else {
                val alert = AlertDialog.Builder(this)
                    .setTitle("Ошибка")
                    .setMessage("У вас есть незаполненные поля")
                    .setPositiveButton("Ok", null)
                    .create()
                    .show()
            }

        }
    }




}