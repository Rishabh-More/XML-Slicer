package com.qwerty.soapapitest.codebase.models.elements

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

//import org.simpleframework.xml.Element
//import org.simpleframework.xml.Root

//@Root(name = "SelectionByResponsibleEmployeeID")
@Xml(name = "SelectionByResponsibleEmployeeID")
class SelectionByResponsibleEmployeeID {
    @PropertyElement(name = "InclusionExclusionCode")
    var incExclusionCode: String? = null

    @PropertyElement(name = "IntervalBoundaryTypeCode")
    var intervalBoundaryTypeCode: Int? = null

    @PropertyElement(name = "LowerBoundaryResponsibleEmployeeID")
    var lowerBoundaryEmployeeID: String? = null
}