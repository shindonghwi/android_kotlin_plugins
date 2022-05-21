package com.github.shindonghwi.wolfkotlinplugins.services

import com.intellij.openapi.project.Project
import com.github.shindonghwi.wolfkotlinplugins.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
