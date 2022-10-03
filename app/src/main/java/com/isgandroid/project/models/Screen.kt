package com.isgandroid.project.models

sealed class Screen(val route: String) {
    object Home : Screen(route = "home_screen")
    object Detail : Screen(route = "detail_screen/{id}") {

        var postId = 0;
        fun passId(id: Int) : String {
            postId = id;
            return "detail_screen/$id"
        }
        fun getId() : Int {
            return postId;
        }
    }
    object Account : Screen(route = "account_screen")
}
