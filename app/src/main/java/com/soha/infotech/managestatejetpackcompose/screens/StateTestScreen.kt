package com.soha.infotech.managestatejetpackcompose.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.soha.infotech.managestatejetpackcompose.viewmodel.StateTestViewModel

// remember -> persist state on recomposition
// rememberSaveable -> persist on even configuration changes
// ViewModel and LiveData -> Hoist the state for re-usability

@Composable
fun StateTestScreen(viewModel: StateTestViewModel) {
    Log.i("SOHA", "is called")
    // remember
    /*var name by remember {
        mutableStateOf("")
    }*/

    // rememberSaveable
    /* var name by rememberSaveable {
         mutableStateOf("")
     }*/

    // ViewModel
    val name by viewModel.name.observeAsState("")
    val surName by viewModel.surName.observeAsState("")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // MyText(name)
        MyText("$name $surName")
        MyTextField(name, onNameValueChange = {
            // name = it
            viewModel.onNameUpdate(it)
        })
        MyTextField(surName, onNameValueChange = {
            viewModel.onSurNameUpdate(it)
        })
    }
}

@Composable
fun MyText(name: String) {
    Text(
        text = "Hello, $name",
        style = TextStyle(fontSize = 30.sp)
    )
}

@Composable
fun MyTextField(name: String, onNameValueChange: (String) -> Unit) {
    /* var name by remember {
         mutableStateOf("")
     }*/
    OutlinedTextField(
        value = name,
        onValueChange = {
            onNameValueChange(it)
        },
        label = {
            Text(text = "Enter name")
        }
    )
}