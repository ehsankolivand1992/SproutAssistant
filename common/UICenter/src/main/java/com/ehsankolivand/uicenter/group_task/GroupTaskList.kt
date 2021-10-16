package com.ehsankolivand.uicenter.group_task

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.RadioButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ehsankolivand.uicenter.R
import com.ehsankolivand.uicenter.bottom_nav_bar.BottomNavigationBar
import com.ehsankolivand.uicenter.toolbar.Header




@Composable
fun LazyGroups()
{

}




@Composable
fun GroupItems()
{
    val mRememberObserver = remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(modifier = Modifier.fillMaxWidth()
            ,verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center)
        {

            Box(modifier = Modifier
                .weight(6f)
                .padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 5.dp)
                .clip(shape = RoundedCornerShape(1.dp))
                .shadow(elevation = 0.5.dp,
                    shape = RoundedCornerShape(10.dp))
            ) {
                Row(modifier = Modifier
                    .padding(start = 15.dp),
                verticalAlignment = Alignment.CenterVertically
                    ,horizontalArrangement = Arrangement.Center)
                {
                    RadioButton(
                        selected = mRememberObserver.value == "test",
                        onClick = { mRememberObserver.value = "mText" }
                    ,modifier = Modifier.padding(10.dp))
                    Text(text = "Learning")

                }
            }
        }




    }
}


@Preview
@Composable
fun GroupPreview()
{
    Scaffold(modifier=
    Modifier.background(Color(R.color.white)),
        topBar = { Header() },
        bottomBar = { BottomNavigationBar() }
    ) {
        GroupItems()
    }

}