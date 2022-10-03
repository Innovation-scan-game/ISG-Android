package com.isgandroid.project.views.theme.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.isgandroid.project.models.Screen

@Composable
fun AccountScreen(
    navController: NavController
) {
    val scaffoldState = rememberScaffoldState()
    val context = LocalContext.current

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(Screen.Home.route)
                    }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                title = {
                    Text(
                        text = "Account page",
                        fontSize = 20.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            )
        },
        content = {
            var uname by remember { mutableStateOf(TextFieldValue("")) };
            var pword by remember { mutableStateOf(TextFieldValue("")) };

            var loggedIn = false;
            if (!loggedIn) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(
                        text = "Login to your account",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.padding(vertical = 10.dp))

                    Text(text = "Username")
                    Row() {
                        TextField(
                            value = uname,
                            modifier = Modifier
                                .fillMaxWidth(),
                            onValueChange = { newText ->
                                uname = newText
                            }
                        )
                    }

                    Spacer(modifier = Modifier.padding(vertical = 10.dp))

                    Text(text = "Password")
                    Row() {
                        TextField(
                            value = pword,
                            modifier = Modifier
                                .fillMaxWidth(),
                            onValueChange = { newText ->
                                pword = newText
                            }
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.padding(vertical = 20.dp)
                    ) {
                        Button(
                            // ON LOGIN CLICK
                            onClick = {
                                if (uname.text.isNullOrEmpty() || pword.text.isNullOrEmpty()) {
                                    showMessage(context, "Please, make sure every field is filled in correctly.")
                                }
                                else {

                                }
                            },
                            contentPadding = PaddingValues(
                                start = 20.dp,
                                top = 12.dp,
                                end = 20.dp,
                                bottom = 12.dp
                            )
                        ) {
                            Icon(
                                Icons.Default.Lock,
                                contentDescription = "Login_btn",
                                modifier = Modifier.size(ButtonDefaults.IconSize)
                            )
                            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                            Text("Login")
                        }
                    }

                }
            } else {
                Text(text = "Hi! ")
            }
        },
        bottomBar = { }
    )
}

@Composable
@Preview(showBackground = true)
fun AccountScreenPreview() {
    AccountScreen(
        rememberNavController()
    )
}

fun showMessage(context: Context, message:String){
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}