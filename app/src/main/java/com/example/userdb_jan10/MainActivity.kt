package com.example.userdb_jan10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container_view, UserFragment())
                .commit()


        }
    }
}