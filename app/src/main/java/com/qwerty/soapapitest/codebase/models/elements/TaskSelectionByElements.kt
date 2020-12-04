package com.qwerty.soapapitest.codebase.models.elements

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Xml

//import org.simpleframework.xml.Root
//import org.simpleframework.xml.Element
//import org.simpleframework.xml.ElementList

//@Root(name = "SiteLogisticsTaskSelectionByElements")
@Xml(name = "SiteLogisticsTaskSelectionByElements")
class TaskSelectionByElements {
    @Element(name = "SelectionByProcessTypeCode")
    var processTypeCode: SelectionByProcessTypeCode? = null

    @Element(name = "SelectionByResponsibleEmployeeID")
    var responsibleEmployeeIDs: List<SelectionByResponsibleEmployeeID>? = null

    @Element(name = "SelectionByProcessingStatusCode")
    var processingStatusCode: List<SelectionByProcessingStatusCode>? = null
}