package com.hb.ulanganhabli

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login: Button = findViewById(R.id.login)
        login.setOnClickListener { login() }
    }

    private fun login(){
        val username: EditText = findViewById(R.id.username)
        val password: EditText = findViewById(R.id.password)

        val username1 = username.text.toString()

        if (username.text.isEmpty() && password.text.isEmpty()){
            Toast.makeText(this, "data login harus di isi", Toast.LENGTH_SHORT).show()

        }else if (username.text.toString() == "root" && password.text.toString() == "root"){

            val login = Intent (this@MainActivity,welcome::class.java)
            login.putExtra("login", "selamat datang $username1")
            startActivity(login)

        }else{
            Toast.makeText(this, "username dan password anda salah", Toast.LENGTH_SHORT).show()
        }

    }
    }
