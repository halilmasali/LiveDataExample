package com.example.livedataexample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class ExampleDataClass(context: Context) {
    //Create a MainViewModel using the given context and lazy initialization
    private val viewModel by lazy {
        ViewModelProvider((context as AppCompatActivity))[MainViewModel::class.java]
    }

    //An example variable was created to simulate the data class
    private var exampleData = 0

    // This function increments the count value by 1.
    fun plusCount(){
        viewModel.getCount(++exampleData)
    }
}