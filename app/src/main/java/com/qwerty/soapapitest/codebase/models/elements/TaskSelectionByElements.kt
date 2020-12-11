package com.qwerty.soapapitest.codebase.models.elements

import org.simpleframework.xml.Root
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList

@Root(name = "SiteLogisticsTaskSelectionByElements")
data class TaskSelectionByElements @JvmOverloads constructor (
    @field:Element(name = "SelectionByProcessTypeCode", required = false)
    var processTypeCode: SelectionByProcessTypeCode? = null,

    @field:ElementList(name = "SelectionByResponsibleEmployeeID", inline = true)
    var responsibleEmployeeIDs: List<SelectionByResponsibleEmployeeID>? = null,

    @field:ElementList(name = "SelectionByProcessingStatusCode", inline = true)
    var processingStatusCode: List<SelectionByProcessingStatusCode>? = null
)