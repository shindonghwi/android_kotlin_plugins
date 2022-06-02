package com.github.shindonghwi.wolf_template.compose_bottomnavigation.sources.nav_graph

import android.databinding.tool.ext.toCamelCase

fun menuNavGraph(
    menuName: String,
    defaultPackage: String,
) = """
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import $defaultPackage.model.screen_router.AccountScreenRouter
import $defaultPackage.screen.detail.DetailScreen
import $defaultPackage.screen.account.AccountScreen

fun NavGraphBuilder.add${menuName.toCamelCase()}Graph(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    composable(${menuName.toCamelCase()}ScreenRouter.ROOT.route) {
        ${menuName.toCamelCase()}Screen {
            navController.navigate(${menuName.toCamelCase()}ScreenRouter.DETAIL.route)
        }
    }
    composable(${menuName.toCamelCase()}ScreenRouter.DETAIL.route) {
        DetailScreen(from = ${menuName.toCamelCase()}ScreenRouter.DETAIL.route)
    }
}
"""
