package com.example.assignment5

import SecondActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.ImageView
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pic = findViewById<View>(R.id.hat) as ImageView

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener{
            pic.setBackgroundResource(R.mipmap.my_image)
        }

        val arrayAdapter: ArrayAdapter<*>
        val users = arrayOf(
            "Süreyya", "Ahmet", "Mehmet",
            "Ayşe", "Fatma"
        )

        val mListView = findViewById<ListView>(R.id.userlist)
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, users)
        mListView.adapter = arrayAdapter

        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.settings -> Toast.makeText(this,"Settings Selected",Toast.LENGTH_SHORT).show()
            R.id.exit -> Toast.makeText(this,"Exit Selected",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}
