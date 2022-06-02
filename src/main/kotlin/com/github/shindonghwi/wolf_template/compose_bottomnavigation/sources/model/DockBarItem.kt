package com.github.shindonghwi.wolf_template.compose_bottomnavigation.sources.model

import org.jetbrains.kotlin.util.capitalizeDecapitalize.toLowerCaseAsciiOnly
import org.jetbrains.kotlin.util.capitalizeDecapitalize.toUpperCaseAsciiOnly


fun menuDockBar(
    menuList: List<String>,
    defaultPackage: String,
) = """
package $defaultPackage
import androidx.annotation.DrawableRes
import $defaultPackage.R

enum class DockBarItem(
    val route: String,
    @DrawableRes val icon: Int
) {
    ${getDockBarString(menuList)}
}
"""

fun getDockBarString(menuList: List<String>): String {
    var dockBarString = ""

    repeat(menuList.size) {
        dockBarString += "${menuList[it].toUpperCaseAsciiOnly()}(\"${menuList[it].toLowerCaseAsciiOnly()}\", R.drawable.ic_dockbar_on_home),\n"
    }

    return dockBarString
}