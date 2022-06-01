package com.github.shindonghwi.wolf_template.compose_bottomnavigation

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.addAllKotlinDependencies
import com.github.shindonghwi.wolf_template.compose_bottomnavigation.sources.composeActivity
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

fun RecipeExecutor.composeBottomNavigationSetup(
    moduleData: ModuleTemplateData,
    defaultPackage: String,
    newFilePackage: String,
    activityName: String,
    bottomMenuTabList: String
) {
    val (projectData, srcOut, resOut) = moduleData

    addAllKotlinDependencies(moduleData)
    val format = SimpleDateFormat("yyyy/MM/dd")
    val date = format.format(Date())

    val path = srcOut.absolutePath.replace("java", "kotlin")
    val srcKotlinDir = File(path)
    save(
        composeActivity(date, defaultPackage, activityName, moduleData),
        srcKotlinDir.resolve("${activityName}.kt")
    )
//    save(
//        someFragmentViewModel(date, defaultPackage, newFilePackage, entityName, layoutName, projectData),
//        srcKotlinDir.resolve("${entityName}ViewModel.kt"))
//    save(
//        someFragmentLayout(defaultPackage, newFilePackage, entityName),
//        resOut.resolve("layout/$layoutName.xml")
//    )
//    save(
//        someActivity(packageName, entityName, layoutName, projectData),
//        srcOut.resolve("$activityClass.kt")
//    )
//    save(someActivityLayout(packageName, entityName),
//        resOut.resolve("layout/$layoutName.xml")
//    )
}