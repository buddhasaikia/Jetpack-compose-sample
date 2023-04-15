package com.example.jetpackcomposesample.home

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object RowDemoScreen : Screen("row_demo_screen")
    object ColumnDemoScreen : Screen("column_demo_screen")
    object BoxDemoScreen : Screen("box_demo_screen")
    object TextModificationDemoScreen : Screen("text_modification_demo_screen")
    object ExpandableCardDemoScreen : Screen("expandable_card_demo_screen")
    object TextFieldDemoScreen : Screen("text_field_demo_screen")
    object ButtonDemoScreen : Screen("button_demo_screen")
    object CoilImageDemoScreen : Screen("coil_image_demo_screen")
    object LazyListDemoScreen : Screen("lazy_list_demo_screen")
    object LazyListWithStickyHeaderDemoScreen : Screen("lazy_list_with_sticky_header_demo_screen")
    object CircularProgressIndicatorDemoScreen : Screen("circular_progress_indicator_demo_screen")
    object BottomNavigationDemoScreen : Screen("bottom_navigation_demo_screen")
}