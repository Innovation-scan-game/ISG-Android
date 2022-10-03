package com.isgandroid.project.views.theme.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.isgandroid.project.models.Screen

@Composable
fun HomeScreen(
    navController: NavController
) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Empty",
                        fontSize = 20.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                actions = {
                    IconButton(onClick = {
                        navController.navigate(Screen.Account.route)

                    }) {
                        Icon(
                            Icons.Default.AccountBox,
                            contentDescription = "Account_btn",
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                    IconButton(onClick = {

                    }) {
                        Icon(
                            Icons.Default.Refresh,
                            contentDescription = "Refresh_btn",
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                }
            )
        },
        content = { },
        bottomBar = { BottomAppBar() { } }
    )
}