package ru.lib.example

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MyLibraryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mylibrary)

        val textView = findViewById<TextView>(R.id.tvMessage)
        textView.text = MySingleton.doSomething()
    }
}