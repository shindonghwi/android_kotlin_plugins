package com.github.shindonghwi.wolf_template.compose_bottomnavigation

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider

class ComposeBottomNavigationProviderImpl  : WizardTemplateProvider() {
    override fun getTemplates(): List<Template> = listOf(composeBottomNavigationWizardTemplate)
}
