package com.github.shindonghwi.wolf_template.compose_bottomnavigation

import android.databinding.tool.ext.toCamelCase
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.addAllKotlinDependencies
import com.github.shindonghwi.wolf_template.compose_bottomnavigation.sources.activity.composeActivity
import com.github.shindonghwi.wolf_template.compose_bottomnavigation.sources.app.wolfApp
import com.github.shindonghwi.wolf_template.compose_bottomnavigation.sources.nav_graph.menuNavGraph
import com.github.shindonghwi.wolf_template.compose_bottomnavigation.utils.CreateFilePackage
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

fun RecipeExecutor.composeBottomNavigationSetup(
    moduleData: ModuleTemplateData,
    defaultPackage: String,
    newFilePackage: String,
    activityName: String,
    bottomMenuTabList: List<String>
) {
    val (projectData, srcOut, resOut) = moduleData

    addAllKotlinDependencies(moduleData)
    val format = SimpleDateFormat("yyyy/MM/dd")
    val date = format.format(Date())

    val path = srcOut.absolutePath.replace("java", "kotlin")
    val srcKotlinDir = File(path)

    /** 패키지 생성 */
    CreateFilePackage.bottomMenuPackage(path = path, bottomMenuTabList = bottomMenuTabList)
    CreateFilePackage.navigationPackage(path = path, bottomMenuTabList = bottomMenuTabList)

    /** ComposeActivity */
    save(
        composeActivity(date, defaultPackage, activityName, moduleData, bottomMenuTabList),
        srcKotlinDir.resolve("${activityName}.kt")
    )

    /** WolfApp */
    save(
        wolfApp(date, defaultPackage, moduleData),
        srcKotlinDir.resolve("WolfApp.kt")
    )

    /** NavGraph */
    bottomMenuTabList.forEach { menuName ->
        save(
            menuNavGraph(menuName, defaultPackage),
            srcKotlinDir.resolve("$path/navigation/nav_graph/${menuName.toCamelCase()}NavGraph.kt")
        )
    }




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