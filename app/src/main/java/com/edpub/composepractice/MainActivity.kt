package com.edpub.composepractice

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListsFun()
        }
    }
}

@Composable
fun MyScreen(){
    Column() {

        val checked1 = remember{
            mutableStateOf(false)
        }

        val check2 = remember {
            mutableStateOf(false)
        }

        Switch(checked = checked1.value, onCheckedChange ={
            checked1.value = it
            Log.i("fuck", "sick1")
        } )
        Switch(checked = check2.value, onCheckedChange ={
            Log.i("fuck", "sick2")
            check2.value = it
        } )
    }
}

@Preview
@Composable
fun Preview(){
    MyScreen2()
}

@Composable
fun MyScreen2(){

    val scope = rememberCoroutineScope()

    val scaffoldState = rememberScaffoldState()

    var textField by remember {
        mutableStateOf("")
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) {
        Column() {
            TextField(value = textField, onValueChange = {
                textField = it
            },
            label = {
                Text("Enter your name")
            })
            Button(
                onClick = {
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("Message on snackbar")
                    }
                }
            ){
                Text("Press me")
            }
        }
    }
}

@Composable
fun ScrollableCol(){
    //For short scrollable columns
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.verticalScroll(scrollState)
    ){
        for(i in 1..50){
            Text("Fuck $i")
        }
    }
}

@Composable
fun ListsFun(){
    LazyColumn{
        items(5000){
            Text("Sexy $it")
        }
    }
}