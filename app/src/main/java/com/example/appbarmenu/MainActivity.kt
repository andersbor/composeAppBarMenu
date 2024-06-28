package com.example.appbarmenu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appbarmenu.ui.theme.AppBarMenuTheme
import androidx.compose.ui.Alignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppBarMenuTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = { MyAppBarWithMenu() }
                ) { innerPadding ->
                    Greeting(name = "Android", modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

// https://fvilarino.medium.com/creating-a-reusable-actions-menu-in-jetpack-compose-95aec8eeb493
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBarWithMenu(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    Box(/*modifier = modifier.fillMaxSize()*/
        contentAlignment = Alignment.Center
    ) {
        TopAppBar(
            title = { Text("My App") },
            actions = {
                IconButton(onClick = { }) {
                    Icon(Icons.Filled.Call, contentDescription = "Call")
                }
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(Icons.Filled.MoreVert, contentDescription = "More options")
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    //modifier = modifier.align(Alignment.TopEnd

                    // TODO should align TopEnd but is Right aligned
                ) {
                    DropdownMenuItem(text = { Text("Option 1") },
                        onClick = { /* Handle click */
                            expanded = false
                        })
                    DropdownMenuItem(text = { Text("Option 2") },
                        onClick = { /* Handle click */
                            expanded = false
                        })
                    // Add more options as needed
                }
            }
        )
        /*DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = modifier.align(Alignment.TopEnd)
            // TODO should align TopEnd but is Right aligned
        ) {
            DropdownMenuItem(text = { Text("Option 1") }, onClick = { /* Handle click */ })
            DropdownMenuItem(text = { Text("Option 2") }, onClick = { /* Handle click */ })
            // Add more options as needed
        }*/
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppBarMenuTheme {
        MyAppBarWithMenu()
    }
}