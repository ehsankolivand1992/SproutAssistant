package com.ehsankolivand.uicenter.bottom_nav_bar

import com.ehsankolivand.uicenter.R


sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.mipmap.home, "Home")
    object Calendar : NavigationItem("calendar", R.mipmap.ic_calendar, "Calendar")
    object Add : NavigationItem("add", R.mipmap.ic_add, "Add")
    object Notification : NavigationItem("notification", R.mipmap.ic_notification, "Notification")
    object Profile : NavigationItem("profile", R.mipmap.ic_profile, "Profile")
}