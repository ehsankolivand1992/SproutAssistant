package com.ehsankolivand.uicenter.bottom_nav_bar

import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ehsankolivand.uicenter.R


@Composable
fun BottomNavigationBar() {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Calendar,
        NavigationItem.Add,
        NavigationItem.Notification,
        NavigationItem.Profile
    )


    Column(modifier = Modifier.fillMaxWidth()) {


        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {

            items.forEach {
                if (it.title.equals("Add")) {
                    Image(painter = painterResource(id = it.icon),
                        contentDescription = it.title, modifier =
                        Modifier
                            .weight(1f)
                            .requiredHeight(70.dp)
                            .requiredWidth(70.dp)
                            .absoluteOffset(y = -1.dp)
                            .clickable {
                                NavigationClickHandler(it)
                            })
                } else {
                    Image(painter =
                    painterResource(id = it.icon),
                        contentDescription =
                        it.title, modifier =
                        Modifier.weight(1f)
                            .clickable {
                                NavigationClickHandler(it)
                            })
                }

            }


        }
        Spacer(modifier = Modifier.height(10.dp))
    }

}


fun NavigationClickHandler( itme: NavigationItem)
{
    when(itme.route)
    {
        "home"->{
            Log.i("nav_click","home")
        }
        "calendar"->{
            Log.i("nav_click","calendar")

        }
        "add"->{
            Log.i("nav_click","add")

        }
        "notification"->{
            Log.i("nav_click","notification")

        }
        "profile"->{
            Log.i("nav_click","profile")

        }
    }
}



@Preview
@Composable
fun PreviewBottomBar()
{
    Scaffold(modifier=Modifier.background(Color(R.color.white)),
        bottomBar = { BottomNavigationBar() }
    ) {

    }
}