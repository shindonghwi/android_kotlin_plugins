package com.github.shindonghwi.wolf_template.compose_bottomnavigation.sources

import com.android.tools.idea.wizard.template.ModuleTemplateData

fun composeActivity(
    date: String,
    defaultPackage: String,
    activityName: String,
    moduleData: ModuleTemplateData
) = """package $defaultPackage
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
class $activityName : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ${moduleData.themesData.appName}Theme {
                WolfApp()
            }
        }
    }
}
"""