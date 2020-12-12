package com.qwerty.soapapitest.codebase.models.soapservice.data

import org.simpleframework.xml.Root
import org.simpleframework.xml.Element
import com.qwerty.soapapitest.codebase.models.soapservice.elements.ProcessingConditions
import com.qwerty.soapapitest.codebase.models.soapservice.elements.TaskSelectionByElements
import org.simpleframework.xml.Order

@Root(name = "glob:SiteLogisticsTaskByElementsQuery_sync")
@Order(elements = ["SiteLogisticsTaskSelectionByElements","ProcessingConditions"])
data class TasksByElementsQueryData @JvmOverloads constructor (

    @field:Element(name = "SiteLogisticsTaskSelectionByElements", required = false)
    var taskSelectionByElements: TaskSelectionByElements? = null,

    @field:Element(name = "ProcessingConditions", required = false)
    var processingConditions: ProcessingConditions? = null
)