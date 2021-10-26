package com.ehsankolivand.uicenter.dialogs

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ehsankolivand.constants.database.PriorityColorEnum
import com.ehsankolivand.todo_datasource.entity.BaseTodoEntity
import com.ehsankolivand.uicenter.R
import com.ehsankolivand.uicenter.ui_connector_interfaces.ConnectorAddGroupDialog


//-----------------------
@Composable
fun AddGroupDialog(connectorAddGroupDialog: ConnectorAddGroupDialog ) {

    var inputValue by rememberSaveable { mutableStateOf(BaseTodoEntity()) }

    MaterialTheme {
        Column {
            val openDialog = remember{ mutableStateOf(false)}
            val sticker = remember{ mutableStateOf(false)}
            val titleText = remember {
                mutableStateOf("")
            }

            Button(onClick = { openDialog.value = true },
                colors = ButtonDefaults.buttonColors(
                    Color(PriorityColorEnum.LightOrange.getHexCode()))) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(R.string.add_new_group_tasks)
                    )
                }
            }
            if (openDialog.value) {

                AlertDialog(
                    onDismissRequest = {

                        openDialog.value = false


                    },
                    title = {
                        Column(modifier = Modifier.fillMaxWidth()) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = stringResource(R.string.add_new_group),
                                    modifier= Modifier.padding(10.dp))
                            }


                            OutlinedTextField(value =titleText.value, onValueChange = {
                                titleText.value = it
                                                                          inputValue.title = it
                            },modifier = Modifier.fillMaxWidth(),label =
                                { Text(text = stringResource(R.string.dialog_title))})
                            Column(horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,modifier =
                                Modifier.fillMaxWidth()) {
                               Text(text = stringResource(R.string.choose_emoji),
                                    modifier= Modifier.padding(top = 20.dp,bottom = 5.dp))


                                HorizontallyEmojiList(inputValue)


                                Text(text = stringResource(R.string.choose_color),
                                    modifier= Modifier.padding(top=20.dp,bottom = 5.dp))
                                Spacer(modifier = Modifier
                                    .fillMaxWidth()
                                    .requiredHeight(20.dp))

                                HorizantalPriorityColor(inputValue)

                            }

                        }


                    },


                    confirmButton = {
                        
                        Spacer(modifier = Modifier
                            .fillMaxWidth()
                            .requiredHeight(20.dp))
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Button(

                                onClick = {
                                    titleText.value = ""
                                    openDialog.value = false

                                },
                                Modifier
                                    .weight(1f),
                                        colors = ButtonDefaults
                                            .buttonColors(backgroundColor = Color.Red))
                            {
                                Text(stringResource(R.string.dialog_x))
                            }
                            Divider(modifier = Modifier.width(2.dp))
                            Button(
                                onClick = {

                                    openDialog.value = false
                                   connectorAddGroupDialog.SaveGroupTask(inputValue)
                                    titleText.value = ""
                                }, Modifier.weight(2f),
                                   colors =
                                   ButtonDefaults.buttonColors(backgroundColor = Color.Green))
                            {
                                Text(stringResource(R.string.save))
                            }

                        }

                    }


                )
            }

            //-----------------------

        }

    }
}

//-----------------------
@Composable
fun HorizontallyEmojiList(inputValue: BaseTodoEntity) {


    val emojies = EmojiEnum.values()

    val listState = rememberLazyListState()
    var selectedEmoji by remember {
     mutableStateOf(-1)
    }
    LazyRow(modifier = Modifier.fillMaxWidth(),state = listState) {

        items(items = emojies, itemContent = { item ->

            Surface(modifier = Modifier
                .background(
                    if (item.getUnicode() == selectedEmoji)
                        Color.Red else Color.White
                )
                .selectable(selected = item.getUnicode() == selectedEmoji,
                    onClick = {
                        inputValue.sticker = item.getUnicode()
                        if (selectedEmoji != item.getUnicode()) {
                            selectedEmoji = item.getUnicode()
                        }
                    })
                .padding(1.dp)) {

            Text(text = "${getEmojiByUnicode(item.getUnicode())}",
                fontSize = 30.sp)
            }
        })
    }
}

//-----------------------
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizantalPriorityColor(inputValue: BaseTodoEntity) {


    val priorityColor = PriorityColorEnum.values()

    val listState = rememberLazyListState()

    var selectedIndex by remember {
        mutableStateOf<Long>(-1)
    }

    LazyVerticalGrid(modifier = Modifier.fillMaxWidth(),
        state = listState,
        cells = GridCells.Fixed(4),
        contentPadding = PaddingValues(1.dp)
    ) {

        items(items = priorityColor, itemContent = { item ->



            Surface(modifier = Modifier
                .background(
                    if (item.getHexCode() == selectedIndex)
                        Color.Red else Color.White
                )
                .selectable(
                    selected = item.getHexCode() == selectedIndex,
                    onClick = {
                        inputValue.color = item.getHexCode()
                        if (selectedIndex != item.getHexCode())
                            selectedIndex = item.getHexCode()

                    })
                .padding(1.dp)
                .fillMaxWidth()) {
                Box(
                    modifier = Modifier
                        .clip(
                            shape =
                            RoundedCornerShape(15.dp)
                        )
                        .fillMaxWidth(1f)
                        .requiredHeight(55.dp)
                        .background(
                            color =
                            Color(item.getHexCode())
                        )

                )
            }
        })
    }
}


//-----------------------

fun getEmojiByUnicode(unicode: Int): String? {
    return String(Character.toChars(unicode))
}

//-----------------------
@Preview
@Composable
fun previewDialog()
{
}

