package com.edpub.composepractice

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.edpub.composepractice.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyScreen()
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