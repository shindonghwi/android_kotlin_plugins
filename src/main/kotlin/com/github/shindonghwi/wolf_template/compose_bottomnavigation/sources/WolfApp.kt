package com.github.shindonghwi.wolf_template.compose_bottomnavigation.sources

import com.android.tools.idea.wizard.template.ModuleTemplateData


fun wolfApp(
    date: String,
    defaultPackage: String,
    moduleData: ModuleTemplateData
) = """
package $defaultPackage
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import $defaultPackage.model.DockBarItem
import $defaultPackage.navigation.BottomNavigationBar
import $defaultPackage.screen.theme.AndroidEarlyAdopterTheme

/**
 * Created by ShinDongHwi on ${date}.
 * [EN]Description : Activity for bottom navigation movement
 * [KR]Description : 화면 이동을 위한 바텀네이게이션 화면
*/

@Composable
fun WolfApp() {
    ${moduleData.themesData.appName}Theme {
        val navController = rememberNavController()
        val bottomBarState = rememberSaveable { (mutableStateOf(true)) }

        BottomNavigationVisibleState(navController = navController, bottomBarState = bottomBarState)

        Scaffold(
            bottomBar = { BottomNavigationBar(navController = navController, bottomBarState = bottomBarState) }
        ) {
            WolfAppNavGraph(navController = navController)
        }
    }
}

@Composable
private fun BottomNavigationVisibleState(navController: NavHostController, bottomBarState: MutableState<Boolean>) {
    val scope = rememberCoroutineScope()

    navController.currentBackStackEntryFlow.let { backStackFlow ->
        LaunchedEffect(backStackFlow) {
            scope.launch {
                backStackFlow.collect {
                    when (it.destination.route.toString().replace("/", "")) {
                        DockBarItem.HOME.route,
                        DockBarItem.ACCOUNT.route,
                        DockBarItem.COMPANY.route,
                        DockBarItem.NOTIFICATION.route -> {
                            bottomBarState.value = true
                        }
                        else -> {
                            bottomBarState.value = false
                        }
                    }
                }
            }
        }
    }
}

"""