package com.github.shindonghwi.wolf_template.compose_bottomnavigation


import com.android.tools.idea.wizard.template.*

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
        val activityParam = activityName //
        val bottomMenuTabListParam = bottomMenuTabList //

        widgets(
            TextFieldWidget(packageNameParam),
            TextFieldWidget(activityName),
            TextFieldWidget(bottomMenuTabList),
            PackageNameWidget(pathNameParam)
        )

        recipe = { data: TemplateData ->
            composeBottomNavigationSetup(
                data as ModuleTemplateData,
                packageNameParam.value,
                pathNameParam.value,
                activityParam.value,
                bottomMenuTabListParam.value
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

/** 바텀 네비게이션 전환을 위한 액티비티 */
val activityName
    get() = stringParameter {
        name = "Activity Name"
        default = "WolfComposeBottomNavigationActivity"
        help = "Activity for bottom navigation movement"
        constraints = listOf(Constraint.NONEMPTY)
    }

/** 바텀 네비게이션 메뉴 셋팅 */
val bottomMenuTabList
    get() = stringParameter {
        name = "BottomNavigation Item List [ Categorized by commas ] / ex) home,news,market,account"
        default = "home,news,market,account"
        help = "Set the bottom navigation menu"
        constraints = listOf(Constraint.NONEMPTY)
    }
