package com.github.shindonghwi.wolf_template.compose_bottomnavigation.sources.model

import android.databinding.tool.ext.toCamelCase

fun screenRouter(
    menuName: String,
    defaultPackage: String,
) = """
package $defaultPackage

enum class ${menuName.toCamelCase()}ScreenRouter(val route: String) {
    ROOT("${menuName}/"),
    DETAIL("${menuName}/detail"),
}
"""
