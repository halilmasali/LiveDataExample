package com.example.livedataexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    //Initialize the viewModel and exampleDataClass
    private lateinit var mainViewModel: MainViewModel
    private val exampleDataClass = ExampleDataClass(this)

    //This function is called when the activity is created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Get an instance of MainViewModel using the ViewModelProvider
        //We pass in mainActivity as the owner to ensure that the ViewModel is scoped to this activity.
        mainViewModel = ViewModelProvider(this@MainActivity)[MainViewModel::class.java]

        //Find the button and textView in the layout using their IDs
        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView)

        //Observe the countLiveData and update the text view when it changes
        mainViewModel.countLiveData.observe(this) {
            textView.text = "$it"
        }
        button.setOnClickListener {
            //The function is called to increment a value from the data class
            exampleDataClass.plusCount()
        }
    }
}