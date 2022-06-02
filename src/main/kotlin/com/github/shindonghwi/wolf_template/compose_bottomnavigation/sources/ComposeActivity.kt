package com.github.shindonghwi.wolf_template.compose_bottomnavigation.sources

import com.android.tools.idea.wizard.template.ModuleTemplateData

fun composeActivity(
    date: String,
    defaultPackage: String,
    activityName: String,
    moduleData: ModuleTemplateData,
    bottomMenuTabList: List<String>,
) = """
package $defaultPackage
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

/**
 * Created by ShinDongHwi on ${date}.
 * [EN]Description : Activity for bottom navigation movement
 * [KR]Description : 화면 이동을 위한 바텀네이게이션 화면
*/

class $activityName : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ${moduleData.themesData.appName}Theme {
                WolfApp()
                $bottomMenuTabList
            }
        }
    }
}
"""