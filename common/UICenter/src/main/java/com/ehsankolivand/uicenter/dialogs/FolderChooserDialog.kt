package com.ehsankolivand.uicenter.dialogs

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ehsankolivand.constants.database.PriorityColorEnum
import com.ehsankolivand.todo_datasource.entity.BaseTodoEntity
import com.ehsankolivand.uicenter.R


@Composable
fun folderChooserDialog()
{

    var inputValue by rememberSaveable { mutableStateOf(BaseTodoEntity()) }

    MaterialTheme {
        Column {
            val openDialog = remember{ mutableStateOf(false) }
            val sticker = remember{ mutableStateOf(false) }
            val titleText = remember {
                mutableStateOf("")
            }



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
                            { Text(text = stringResource(R.string.dialog_title)) })
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
                                   // connectorAddGroupDialog.SaveGroupTask(inputValue)
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
