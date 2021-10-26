package com.ehsankolivand.uicenter.toolbar

import android.util.Log
import android.widget.ImageButton
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ehsankolivand.todo_datasource.entity.BaseTodoEntity
import com.ehsankolivand.uicenter.R
import com.ehsankolivand.uicenter.ui_connector_interfaces.ConnectorTopToolbar

@Composable
fun TopToolBarFinal(
    basicTask: BaseTodoEntity,
    connectorTopToolbar: ConnectorTopToolbar) {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )


    Column(modifier =
    Modifier
        .fillMaxWidth()) {
        Spacer(modifier =
        Modifier.height(10.dp))
        Row(modifier =
        Modifier.fillMaxWidth()
            .animateContentSize(
            animationSpec = tween(
                durationMillis = 800,
                easing = LinearOutSlowInEasing
            )
        ),
        verticalAlignment =
        Alignment.Top,
            horizontalArrangement =
            Arrangement.SpaceBetween) {


            IconButton(onClick = { connectorTopToolbar.openSideMenu() }) {
                Image(painter = painterResource(id = R.mipmap.ic_side_menu),
                    contentDescription = "Side Menu")
            }
            Column(
                horizontalAlignment =
            Alignment.CenterHorizontally,
            verticalArrangement =
            Arrangement.Center) {

                Text(text = if (basicTask.title.length>0) basicTask.title else "Uncategory",
                    fontSize = 19.sp,modifier = Modifier.clickable(
                        onClick = {
                            connectorTopToolbar.openCategoryChooserDialog()
                        }
                    ))
                Text(text = "Monday,28",fontSize = 19.sp)

                IconButton(onClick = {

                    expandedState = !expandedState

                }) {
                    Image(painter = painterResource(id = R.mipmap.ic_extend_adaptive_fore),
                        contentDescription = "Extend ToolBar",
                    modifier = Modifier.absoluteOffset(y = -1.dp)
                        .alpha(ContentAlpha.medium)
                        .rotate(rotationState)
                    )
                }

            }
            IconButton(onClick = { /*TODO*/ }) {
                Image(painter = painterResource(id = R.mipmap.ic_profile_boy),
                    contentDescription = "Extend ToolBar",alignment = Alignment.CenterEnd,)
            }


        }
        if (expandedState)
        {
            HorizontalCalendarFinal(listOf(week("Sat", "4"),
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



@Composable
fun HorizontalCalendarFinal( week: List<week>)
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
                        ExampleBoxFinal(shape = CircleShape)
                        ExampleBoxFinal(shape = CircleShape)
                        ExampleBoxFinal(shape = CircleShape)

                    }

                }
            }

        })
    }

}


@Composable
fun ExampleBoxFinal(shape: Shape){
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


@Preview
@Composable
fun PreviewTopToolBar() {
   // TopToolBarFinal(BaseTodoEntity())
}