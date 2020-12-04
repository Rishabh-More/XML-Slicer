package com.qwerty.soapapitest.codebase.models.data

import org.simpleframework.xml.Root
import org.simpleframework.xml.Element
import com.qwerty.soapapitest.codebase.models.elements.ProcessingConditions
import com.qwerty.soapapitest.codebase.models.elements.TaskSelectionByElements

@Root(name = "glob:SiteLogisticsTaskByElementsQuery_sync")
class TasksByElementsQueryData {

    @Element(name = "SiteLogisticsTaskSelectionByElements")
    var taskSelectionByElements: TaskSelectionByElements? = null

    @Element(name = "ProcessingConditions")
    var processingConditions: ProcessingConditions? = null
}