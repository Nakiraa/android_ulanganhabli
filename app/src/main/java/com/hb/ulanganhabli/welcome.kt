package com.hb.ulanganhabli

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.*

val list1 : MutableList<String> = mutableListOf<String>()

class welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val login : String = intent.getStringExtra("login").toString()
        val halaman : TextView = findViewById(R.id.login)
        halaman.text = login.toString()

        val kirim : Button = findViewById(R.id.kirim)
        kirim.setOnClickListener {kirimdata()}
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = getMenuInflater()
        inflater.inflate(R.menu.optionmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.getItemId() == R.id.about){
            val about = Intent (this@welcome,about::class.java)
            startActivity(about)
        }else if(item.getItemId() == R.id.logout){
            val logout = Intent (this@welcome,MainActivity::class.java)
            startActivity(logout)
        }
        return super.onOptionsItemSelected(item)
    }
    
    private fun kirimdata(){
        val namasiswa : EditText = findViewById(R.id.namasisawa)
        val kelas : EditText = findViewById(R.id.kelas)
        val pelajaran : EditText = findViewById(R.id.pelajaran)
        val nilai : EditText = findViewById(R.id.nilai)

        val namasiswa1 = namasiswa.text.toString()
        val kelas1 = kelas.text.toString()
        val pelajaran1 = pelajaran.text.toString()
        val nilai1 = nilai.text.toString()
        val nilai2 = nilai.text.toString().toInt()


        if (namasiswa.text.toString() == "" || kelas.text.toString() == "" || pelajaran.text.toString() == "" || nilai.text.toString() == ""){
            Toast.makeText(this, "masukan data yang kurang", Toast.LENGTH_SHORT).show()
        }
        else if (nilai2 < 75){
            val login = Intent (this@welcome,input::class.java)
            list1.add(
                        "nama siswa     :$namasiswa1 \n" +
                        "kelas                 :$kelas1 \n" +
                        "pelajaran          :$pelajaran1 \n" +
                        "nilai                   :$nilai1 \n" +
                                "$namasiswa1 tidak lulus \n"
            )
            login.putExtra("nilai", "$nilai1")
            startActivity(login)
        }else{
            val login = Intent (this@welcome,input::class.java)
            list1.add(
                "nama siswa     :$namasiswa1 \n" +
                        "kelas                 :$kelas1 \n" +
                        "pelajaran          :$pelajaran1 \n" +
                        "nilai                   :$nilai1 \n" +
                        "$namasiswa1 lulus \n"
            )
            login.putExtra("nilai", "$nilai1")
            startActivity(login)
        }
    }
}