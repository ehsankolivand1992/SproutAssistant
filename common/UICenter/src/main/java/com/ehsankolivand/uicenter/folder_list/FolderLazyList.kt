package com.ehsankolivand.uicenter.folder_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ehsankolivand.constants.getEmojiByUnicode
import com.ehsankolivand.todo_datasource.entity.BaseTodoEntity
import com.ehsankolivand.uicenter.ui_connector_interfaces.ConnectorFolderList


@Composable
fun folderList(basicTask: List<BaseTodoEntity>,connectorFolderList: ConnectorFolderList)
{
    val listState = rememberLazyListState()
    var selectedIndex by remember {
        mutableStateOf<Long>(-1)
    }

    MaterialTheme {
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {
            LazyColumn(modifier =
            Modifier
                .fillMaxHeight()
                .fillMaxWidth(),state = listState
                ,contentPadding = PaddingValues(3.dp)
            ){

                items(items = basicTask, itemContent = { item ->

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .defaultMinSize(minHeight = 30.dp)
                            .background(if (item.id == selectedIndex) Color.Gray else Color.White)
                            .selectable(
                                selected = item.id == selectedIndex,
                                onClick = {
                                    selectedIndex = if (selectedIndex != item.id) item.id else -1

                                    connectorFolderList.selectedFolder(item)
                                    connectorFolderList.closeSideMenu()
                                }
                            )
                            .height(IntrinsicSize.Min)
                            .clip(RoundedCornerShape(2.dp))
                            .shadow(elevation = 1.dp)
                            .padding(start = 1.dp),
                        verticalAlignment =
                        Alignment.CenterVertically
                    ) {

                        if (item.color!=0L) {
                            Divider(
                                color = Color(item.color),
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(10.dp)
                                    .padding(end = 2.dp)
                            )
                        }
                        if (item.sticker!=0) {
                            item.sticker
                                .getEmojiByUnicode()?.let { Text(text = it) }

                        }

                        Text(text = item.title
                            ,modifier = Modifier.padding(start = 2.dp,top = 10.dp,
                                bottom = 10.dp),
                            style = MaterialTheme.typography.h6)

                    }

                }
                )
            }


        }
    }
}



@Preview
@Composable
fun previewFolderList() {
/*
    folderList(listOf(BaseTodoEntity(0,"test"),
        BaseTodoEntity(0,"test"),
        BaseTodoEntity(0,"test"),
        BaseTodoEntity(0,"test")))*/

}