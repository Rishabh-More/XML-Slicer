package com.qwerty.soapapitest.codebase.models.elements

import org.simpleframework.xml.Root
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList

@Root(name = "SiteLogisticsTaskSelectionByElements")
class TaskSelectionByElements {
    @Element(name = "SelectionByProcessTypeCode")
    var processTypeCode: SelectionByProcessTypeCode? = null

    @ElementList(name = "SelectionByResponsibleEmployeeID")
    var responsibleEmployeeIDs: List<SelectionByResponsibleEmployeeID>? = null

    @ElementList(name = "SelectionByProcessingStatusCode")
    var processingStatusCode: List<SelectionByProcessingStatusCode>? = null
}