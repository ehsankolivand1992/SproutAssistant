package com.ehsankolivand.uicenter.lazy_task_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
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
import com.ehsankolivand.uicenter.toolbar.HorizontalCalendar
import com.ehsankolivand.uicenter.toolbar.week





@Composable
fun LazyList(week: List<week>)
{
    LazyColumn(modifier = Modifier.fillMaxWidth()
        ,horizontalAlignment = Alignment.End) {
        items(items = week, itemContent = { item ->
            TaskItem()


        })
    }
}
@Composable
fun TaskItem()
{
    Column(modifier = Modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
          ) {
       Row(modifier = Modifier.fillMaxWidth()
           ,verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) 
       {
           Button(onClick = {
                            /*TODO*/
                            },
               modifier = Modifier
               .weight(1f)
               .padding(start = 10.dp)) {
               Image(painter =
               painterResource(
                   id = android.R.drawable.arrow_down_float)
                   , contentDescription ="extend" )
           }
           Box(modifier = Modifier
               .weight(6f)
               .padding(start = 10.dp, end = 10.dp
                   , top = 10.dp, bottom = 5.dp)
               .clip(shape = RoundedCornerShape(1.dp))
               .shadow(elevation = 0.5.dp,
                   shape = RoundedCornerShape(10.dp))
               ) {
               Column(modifier = Modifier
                   .padding(start = 15.dp)
                   .requiredHeight(150.dp),
               verticalArrangement
               = Arrangement.Center)
               {

                   Text(text = "Title",
                       modifier =
                       Modifier.padding(start = 5.dp,end=5.dp,bottom = 5.dp),fontSize = 20.sp)
                   Text(text = "Greater, form. God grass seasons created All them of also. Fowl land one green. Likeness stars spirit subdue doesn't can't."
                   ,maxLines = 3)
               }
           }
       }
        Row(modifier = Modifier.fillMaxWidth().padding(end = 20.dp),horizontalArrangement = Arrangement.End) {
            Text(text = "Done",modifier = Modifier.padding(start = 5.dp,end=5.dp,bottom = 5.dp),fontSize = 20.sp)
            Text(text = "Edit",modifier = Modifier.padding(start = 5.dp,end=5.dp,bottom = 5.dp),fontSize = 20.sp)
            Text(text = "Delete",modifier = Modifier.padding(start = 5.dp,end=5.dp,bottom = 5.dp),fontSize = 20.sp)

        }



    }
}


@Preview
@Composable
fun Preview(){
    Surface(modifier = Modifier.background(Color(R.color.pink_lace))) {

        Scaffold(
            topBar = {
                Header()
            },
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
                LazyList(listOf(week("Sat", "4"),
                    week("Sat", "4")))


            }


        }

    }

}

data class week(val name:String,val dateNumber:String)