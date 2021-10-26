package com.ehsankolivand.sproutassistant

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.ehsankolivand.sproutassistant.databinding.ActivityMainBinding
import com.ehsankolivand.uicenter.dialogs.AddGroupDialog
import com.ehsankolivand.todo_datasource.entity.BaseTodoEntity
import com.ehsankolivand.uicenter.bottom_nav_bar.BottomNavigationBar
import com.ehsankolivand.uicenter.dialogs.folderChooserDialog
import com.ehsankolivand.uicenter.folder_list.folderList
import com.ehsankolivand.uicenter.toolbar.TopToolBarFinal
import com.ehsankolivand.uicenter.ui_connector_interfaces.ConnectorAddGroupDialog
import com.ehsankolivand.uicenter.ui_connector_interfaces.ConnectorFolderList
import com.ehsankolivand.uicenter.ui_connector_interfaces.ConnectorTopToolbar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity(),ConnectorAddGroupDialog,ConnectorTopToolbar,ConnectorFolderList {

    private lateinit var appBarConfiguration: AppBarConfiguration

    private lateinit var binding: ActivityMainBinding



    private val appViewModelFactory:AppViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

      //  setSupportActionBar(binding.appBarMain.toolbar)

      /*  binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view,
                "Replace with your own action",
                Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/
        binding.addButtonCompose.setContent {

            var state = mutableStateListOf<List<BaseTodoEntity>>()

            AddGroupDialog(
                this)

        }
        binding.appBarMain.topToolbar.setContent {

            TopToolBarFinal( BaseTodoEntity(),
                this)
        }
        binding.appBarMain.buttonMenu.setContent {

            BottomNavigationBar()

        }

        binding.folderList.setContent {


            val foldersData= appViewModelFactory.BaseTodoObservable.observeAsState()



            foldersData.value?.let { folderList(basicTask = it,this) }



        }
        val drawerLayout: DrawerLayout = binding.drawerLayout

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )


    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }



    override fun onSupportNavigateUp(): Boolean {

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


    override fun SaveGroupTask(baseTodoEntity: BaseTodoEntity) {

        appViewModelFactory.insert(baseTodoEntity)
    }

    override fun SaveGroupState(baseTodoEntity: BaseTodoEntity) {

    }



    override fun openSideMenu() {
        binding.drawerLayout.open()
    }

    override fun showCategoryDialog() {
        TODO("Not yet implemented")
    }

    override fun openCategoryChooserDialog() {
        Log.i("test","openCategoryChooserDialog")
        binding.addButtonCompose.setContent {

            var state = mutableStateListOf<List<BaseTodoEntity>>()
            folderChooserDialog()


        }
    }

    override fun closeSideMenu() {
        binding.drawerLayout.close()
    }

    override fun selectedFolder(folderSelected: BaseTodoEntity) {
        binding.appBarMain.topToolbar.setContent {

            TopToolBarFinal(
                folderSelected,
                this)
        }
    }
}