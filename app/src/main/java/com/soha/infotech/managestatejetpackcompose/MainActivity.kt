package com.soha.infotech.managestatejetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.soha.infotech.managestatejetpackcompose.screens.StateTestScreen
import com.soha.infotech.managestatejetpackcompose.viewmodel.StateTestViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel by viewModels<StateTestViewModel>()
        setContent {
            StateTestScreen(viewModel)
        }
    }
}