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

const val APP_PREFERENCES = "mysettings"
const val APP_PREFERENCES_LOG = "log"
const val APP_PREFERENCES_EMAIL = "email"
const val APP_PREFERENCES_PAS = "pas"
class MainActivity : AppCompatActivity() {
    private lateinit var username: EditText
    private lateinit var useremail: EditText
    private lateinit var userpassword: EditText
    private lateinit var regbutton: Button
    lateinit var settings: SharedPreferences
    var hasVisited: Boolean? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        username = findViewById(R.id.usname)
        useremail = findViewById(R.id.usemail)
        userpassword = findViewById(R.id.pass)
        regbutton = findViewById(R.id.but_reg)
        settings = getSharedPreferences(APP_PREFERENCES_LOG, Context.MODE_PRIVATE)
        settings = getSharedPreferences(APP_PREFERENCES_EMAIL, Context.MODE_PRIVATE)
        settings = getSharedPreferences(APP_PREFERENCES_PAS, Context.MODE_PRIVATE)
        hasVisited = settings.getBoolean("hasVisited", false)
        if (hasVisited == false) {
            val x: SharedPreferences.Editor = settings.edit()
            x.putBoolean("hasVisited", true)
            x.apply()
            regbutton.visibility = View.INVISIBLE
        } else {
            regbutton.visibility = View.VISIBLE
        }

        regbutton.setOnClickListener{
            var log = username.getText().toString()
            var email = useremail.getText().toString()
            var password = userpassword.getText().toString()
            var prefEditor = settings.edit()
            prefEditor.putString(APP_PREFERENCES_LOG, log)
            prefEditor.putString(APP_PREFERENCES_EMAIL, email)
            prefEditor.putString(APP_PREFERENCES_PAS, password)
            prefEditor.apply()
            var getuser = settings.getString(APP_PREFERENCES_LOG, "noLog")
            var getemail = settings.getString(APP_PREFERENCES_EMAIL, "noEmail")
            var getpass = settings.getString(APP_PREFERENCES_PAS, "noPas")
            if (username.text.toString().isNotEmpty() || useremail.text.toString().isNotEmpty() || userpassword.text.toString().isNotEmpty()) {
                val toast = Toast.makeText(applicationContext, "Данные сохранены!", Toast.LENGTH_SHORT)
                toast.show()
                if(password == getpass)
                {
                    val intent = Intent(this, GeneralActivity::class.java)
                    startActivity(intent)
                }
                else
                {
                    val toast = Toast.makeText(applicationContext, "Пароль неверный.", Toast.LENGTH_SHORT)
                    toast.show()
                }

            } else {
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