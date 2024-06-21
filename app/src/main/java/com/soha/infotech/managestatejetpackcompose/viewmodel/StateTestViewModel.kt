package com.soha.infotech.managestatejetpackcompose.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StateTestViewModel : ViewModel() {
    private val _name = MutableLiveData<String>()

    // val name: LiveData<String> = _name
    val name: LiveData<String>
        get() = _name

    // Create an event
    fun onNameUpdate(newName: String) {
        _name.value = newName
    }

    // surName
    private val _surName = MutableLiveData<String>()

    val surName: LiveData<String>
        get() = _surName

    fun onSurNameUpdate(newName: String) {
        _surName.value = newName
    }
}