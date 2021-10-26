package com.ehsankolivand.uicenter.toolbar

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ContentAlpha.medium
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ehsankolivand.uicenter.R
import com.ehsankolivand.uicenter.bottom_nav_bar.BottomNavigationBar

@Composable
fun Header()
{
    Surface(modifier = Modifier.background(Color(R.color.pink_lace))) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, top = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.mipmap.ic_side_menu),
                    contentDescription = "Menu"
                )

                Column {
                    Text(text = "Hi, Ehsan")
                    Text(text = "Monday,28")
                }
                Image(
                    painter = painterResource(id = R.mipmap.ic_profile_boy),
                    contentDescription = "boy"
                )

            }
            Image(
                painter = painterResource(id = R.mipmap.ic_extend_adaptive_fore),
                contentDescription = "boy"
                      , modifier = Modifier.height(50.dp)
            )
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
        .wrapContentSize(Alignment.Center)
        .padding(top = 5.dp, start = 1.dp)
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
    ExtendableToolBar()
/*
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
*/
}


//------------ from here
//------------ from here

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExtendableToolBar(
    title: String="test",
    titleFontSize: TextUnit = MaterialTheme.typography.h6.fontSize,
    titleFontWeight: FontWeight = FontWeight.Bold,
    description: String="test",
    descriptionFontSize: TextUnit = MaterialTheme.typography.subtitle1.fontSize,
    descriptionFontWeight: FontWeight = FontWeight.Normal,
    descriptionMaxLines: Int = 4,
    padding: Dp = 12.dp,
    shape: RoundedCornerShape = RoundedCornerShape(4.dp)

) {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = shape,
        onClick = {
            expandedState = !expandedState
        })
    {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, top = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.mipmap.ic_side_menu),
                    contentDescription = "Menu"
                )

                Column {
                    Text(text = "Hi, Ehsan")
                    Text(text = "Monday,28")
                }
                Image(
                    painter = painterResource(id = R.mipmap.ic_profile_boy),
                    contentDescription = "boy"
                )
            }

        }
    }
}








data class week(val name:String,val dateNumber:String)