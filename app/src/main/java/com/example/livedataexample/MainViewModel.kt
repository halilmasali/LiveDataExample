package com.example.livedataexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    //Create a MutableLiveData instance to hold the count value
    //We use lazy initialization to create the instance only when it is needed
    val countLiveData: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    //This function sets the count value in the countLiveData.
    //If there are active observers, the value will be dispatched to them
    fun getCount(count: Int) {
        countLiveData.value = count
    }
}