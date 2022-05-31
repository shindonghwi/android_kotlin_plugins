package com.github.shindonghwi.wolf_template.compose_bottomnavigation

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import com.github.shindonghwi.wolf_template.mvvm.mvvmWizardTemplate

class ComposeBottomNavigationProviderImpl  : WizardTemplateProvider() {
    override fun getTemplates(): List<Template> = listOf(mvvmWizardTemplate)
}
