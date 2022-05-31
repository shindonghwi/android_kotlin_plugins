package com.github.shindonghwi.wolf_template.compose_bottomnavigation


import com.android.tools.idea.wizard.template.*
import com.github.shindonghwi.wolf_template.mvvm.mvvmSetup

val composeBottomNavigationWizardTemplate
    get() = template {
        name = "[Wolf] Compose Bottom Navigation" // 사용자에게 노출될 템플릿명
        description = "Screen movement is implemented Bottom navigation" // 템플릿 설명
        minApi = 21 // 템플릿을 사용 할 수 있는 최소 api 버전
        category = Category.Compose // 컴포즈 카테고리로 지정
        formFactor = FormFactor.Mobile // 템플릿이 사용될 폼 팩터 지정
        screens = listOf(
            WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry,
            WizardUiContext.NewProject, WizardUiContext.NewModule
        )

        val packageNameParam = defaultPackageNameParameter // 템플릿 생성시 패키지 Default 옵션 설정
        val pathNameParam = pathNameParameter // 템플릿 생성시 파일경로 옵션 설정

        /** 바텀 네비게이션 전환을 위한 액티비티 */
        val activityName = stringParameter {
            name = "Activity Name"
            default = "WolfBottomNavActivity"
            help = "Activity for bottom navigation movement"
            constraints = listOf(Constraint.NONEMPTY)
        }

        val layoutName = stringParameter {
            name = "Layout Name"
            default = ""
            help = "The name of the layout to create for the fragment"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { "${fragmentToLayout(activityName.value.toLowerCase())}" }
        }

        widgets(
            TextFieldWidget(packageNameParam),
            TextFieldWidget(activityName),
            TextFieldWidget(layoutName),
            PackageNameWidget(pathNameParam)
        )

        recipe = { data: TemplateData ->
            mvvmSetup(
                data as ModuleTemplateData,
                packageNameParam.value,
                pathNameParam.value,
                activityName.value,
                layoutName.value
            )
        }
    }

/** 패키지명 기본 옵션 설정 */
val defaultPackageNameParameter
    get() = stringParameter {
        name = "Default Package"
        visible = { !isNewModule }
        default = "com.wolf.compose"
        constraints = listOf(Constraint.PACKAGE)
        suggest = { packageName }
    }

/** 파일 Path 기본 옵션 설정 */
val pathNameParameter
    get() = stringParameter {
        name = "New File Location"
        visible = { !isNewModule }
        default = "com.wolf.compose.presentation"
        constraints = listOf(Constraint.PACKAGE)
        suggest = { "$packageName.presentation" }
    }