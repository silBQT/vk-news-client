package com.silbqt.vknewsclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /*
            VkNewsClientTheme {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(8.dp)
                ) {
                    PostCard()
                }
            }
            */

        }
    }
}

/*
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
private fun Test() {
    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text(text = "TopAppBar title") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = true,
                    onClick = {},
                    icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                    label = { Text(text = "Favorite") }
                )
                NavigationBarItem(
                    selected = true,
                    onClick = {},
                    icon = { Icon(Icons.Outlined.Edit, contentDescription = null) },
                    label = { Text(text = "Edit") }
                )
                NavigationBarItem(
                    selected = true,
                    onClick = {},
                    icon = { Icon(Icons.Outlined.Delete, contentDescription = null) },
                    label = { Text(text = "Delete") }
                )
            }
        },
    ) {
        Text(
            modifier = Modifier
                .padding(it),
            text = "hey"
        )
    }
}
*/

/*
@Preview(showBackground = true)
@Composable
private fun Test() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Example2()
    }
}

@Composable
private fun Example1() {
    OutlinedButton(onClick = {}) {
        Text(text = "Button")
    }
}

@Composable
private fun Example2() {
    TextField(value = "", onValueChange = {}, label = { Text(text = "Label") }, shape = RectangleShape)
}
 */