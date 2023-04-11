package com.example.jetpackcomposesample.navigation

const val DETAIL_ARGUMENT_KEY = "id"
const val DETAIL_ARGUMENT_KEY2 = "name"
const val HOME_ARGUMENT_KEY1 = "id"
const val HOME_ARGUMENT_KEY2 = "data"

sealed class Screen(val route: String) {
    object Home : Screen("home_screen?id={$HOME_ARGUMENT_KEY1}&data={$HOME_ARGUMENT_KEY2}") {
        fun passIdAndData(id: Int, data: String): String {
            return "home_screen?id=$id&data=$data"
        }
    }

    object Detail : Screen("detail_screen/{$DETAIL_ARGUMENT_KEY}/{$DETAIL_ARGUMENT_KEY2}") {
        fun passId(id: Int): String {
            //return "detail_screen/$id"
            return this.route.replace(
                oldValue = "{${DETAIL_ARGUMENT_KEY}}",
                newValue = id.toString()
            )
        }

        fun passNameAndId(id: Int, name: String): String {
            return "detail_screen/$id/$name"
        }
    }
}
