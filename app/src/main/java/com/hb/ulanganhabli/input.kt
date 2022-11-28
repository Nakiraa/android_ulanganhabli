package com.hb.ulanganhabli

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class input : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        val listView = findViewById<ListView>(R.id.listdata)
        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list1)

//        val ket : TextView = findViewById(R.id.keterangan)
//        val img : ImageView = findViewById(R.id.img)

        //mengubah nilai ke int
        val ss5 : Int = intent.getStringExtra("nilai").toString().toInt()

        if (ss5 < 75){
//            img.setImageResource(R.drawable.salah1)
        }else{
//            img.setImageResource(R.drawable.benar1)
        }
    }
}