package com.vineesh.myapplication.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.vineesh.myapplication.R
import com.vineesh.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.delay

@Composable
fun MainNavGraph() {

    val backStack = rememberNavBackStack(Screen.LoginScreen)
    val context = LocalContext.current
    var backPressedOnce by remember { mutableStateOf(false) }

    // Effect to reset backPressedOnce after a delay
    LaunchedEffect(backPressedOnce) {
        if (backPressedOnce) {
            delay(2000) // 2 seconds delay
            backPressedOnce = false
        }
    }

    NavDisplay(
        backStack = backStack,
        onBack = {backStack.removeLastOrNull()},
        entryDecorators = listOf(
            rememberSavedStateNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry(Screen.LoginScreen) {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(colorResource(R.color.teal_200)),
                    contentAlignment = Alignment.Center) {
                    Button(onClick = { backStack.add(Screen.Profile) }) {
                        Text(text = "Log-in")
                    }
                }
            }
            entry(Screen.Profile) {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(colorResource(R.color.teal_200)),
                    contentAlignment = Alignment.Center) {
                    Column {
                        Button(onClick = { backStack.add(Screen.NestedGraph) }) {
                            Text(text = "GotoDash Board")
                        }
                        Text(text = "This is profile screen")
                    }
                }
            }
            entry(Screen.NestedGraph) {
                NestedNavGraph(modifier = Modifier, navigateToSettings = {
                    backStack.add(Screen.Profile)
                })
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun mainView() {
    MyApplicationTheme {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.teal_200))) {
            Text(text = "This is first screen")
        }
    }
}