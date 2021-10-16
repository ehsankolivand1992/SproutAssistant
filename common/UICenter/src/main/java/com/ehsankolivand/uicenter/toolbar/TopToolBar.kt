package com.ehsankolivand.uicenter.toolbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ehsankolivand.uicenter.R
import com.ehsankolivand.uicenter.bottom_nav_bar.BottomNavigationBar

@Composable
fun Header()
{
    Surface(modifier = Modifier.background(Color(R.color.pink_lace))) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, top = 10.dp),horizontalArrangement = Arrangement.SpaceBetween,verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = R.mipmap.ic_side_menu), contentDescription = "Menu")

            Column {
                Text(text = "Hi, Ehsan")
                Text(text = "Monday,28")
            }
            Image(painter = painterResource(id = R.mipmap.ic_profile_boy), contentDescription = "boy")
        }
    }

}

@Composable
fun HorizontalCalendar( week: List<week>)
{
    LazyRow(modifier = Modifier.fillMaxWidth()) {

        items(items = week, itemContent = { item ->
            Card(
                shape = RoundedCornerShape(50.dp),modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(5.dp)
                    .shadow(elevation = 5.dp, shape = CircleShape)
            )
            {
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,modifier =
                    Modifier.padding(10.dp)) {
                    Text(text = item.dateNumber)
                    Text(text = item.name)

                    Row {
                        ExampleBox(shape = CircleShape)
                        ExampleBox(shape = CircleShape)
                        ExampleBox(shape = CircleShape)

                    }

                }
            }

        })
    }

}


@Composable
fun ExampleBox(shape: Shape){
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center).padding(top = 5.dp,start = 1.dp)
    ) {
        Box(
            modifier = Modifier
                .size(6.dp)
                .clip(shape)
                .background(Color.Red)
        )
    }
}


@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = "Sprout", fontSize = 18.sp) },
        backgroundColor = colorResource(id = R.color.pink_lace),
        contentColor = Color.White
    )
}

@Composable
fun BottomNavigationBar() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .requiredHeight(60.dp)
        .background(Color(R.color.pink_lace))) {

    }

}






@Preview
@Composable
fun PreviewUi()
{
    Surface(modifier = Modifier.background(Color(R.color.pink_lace))) {

        Scaffold(
            topBar = {
                Header()

            }
            ,
            bottomBar = { BottomNavigationBar() }
        ) {
            Column {
                HorizontalCalendar(listOf(week("Sat", "4"),
                    week("Sat", "4"),
                    week("Sat", "4"),
                    week("Sat", "4"),
                    week("Sat", "4"),
                    week("Sat", "4"),
                    week("Sat", "4"),
                    week("Sat", "4"),
                    week("Sat", "4"),
                    week("Sat", "4"),
                    week("Sat", "4"),
                    week("Sat", "4"),
                    week("Sat", "4"),
                    week("Sat", "4"),
                    week("Sat", "4"),
                    week("Sat", "4"),
                    week("Sat", "4"),
                    week("Sat", "4"),
                    week("Sat", "4")))
            }
        }

    }
}







data class week(val name:String,val dateNumber:String)