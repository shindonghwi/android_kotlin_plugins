package com.github.shindonghwi.wolf_template

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider

class WizardTemplateProviderImpl  : WizardTemplateProvider() {
    // 템플릿 프로바이더 구현 클래스 - 직접 커스텀한 템플릿(mvvmWizardTemplate.Class)를 생성 및 반환하는 역할
    override fun getTemplates(): List<Template> = listOf(mvvmWizardTemplate)
}
