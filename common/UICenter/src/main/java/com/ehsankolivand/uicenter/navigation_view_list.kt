package com.ehsankolivand.uicenter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ehsankolivand.todo_datasource.entity.BaseTodoEntity
import com.ehsankolivand.uicenter.lazy_task_list.TaskItem


@Composable
fun SideNavigationViewList(task:List<BaseTodoEntity>,
                           modifier: Modifier = Modifier
) {

    LazyColumn(modifier = modifier
        .fillMaxWidth()
        .fillMaxHeight()
        ,horizontalAlignment = Alignment.End) {
        items(items = task, itemContent =
        {
                item ->
            NavigationViewItem(item = item)

        })
    }
}

@Composable
fun NavigationViewItem(item: BaseTodoEntity) {

   Surface(color = Color.White) {
       
       
       TODO(" fix color label of god task , in this code is not currect")
       Row(modifier = Modifier.fillMaxWidth()) {
          // if (item.color.isNotEmpty()&& !item.color.equals("non"))
         //  {
               Divider(color = Color.Red,modifier = Modifier
                   .fillMaxHeight()
                   .requiredWidth(10.dp))   
        //   }
           
           Text(text = "Sticker")
       
      Column {
          
      }
       }
   }


}



@Preview
@Composable
fun previewNavigationView() {
    MaterialTheme {
        SideNavigationViewList(listOf(BaseTodoEntity(0,"test","test",0,
        1,false,"done",0)))
        
    }
}