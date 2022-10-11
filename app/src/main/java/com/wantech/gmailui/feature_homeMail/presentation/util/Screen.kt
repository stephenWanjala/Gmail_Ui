package com.wantech.gmailui.feature_homeMail.presentation.util

sealed class Screen(val route:String){
    object HomeScreen:Screen(route = "home_screen")
    object  MeetScreen:Screen(route = "meet_screen")
    object SearchScreen:Screen(route = "search_screen")
    object  ComposeEmailScreen:Screen(route = "compose_mail")
}
