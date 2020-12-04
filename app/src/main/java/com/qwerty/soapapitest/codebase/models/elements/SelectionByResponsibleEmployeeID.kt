package com.qwerty.soapapitest.codebase.models.elements

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "SelectionByResponsibleEmployeeID")
class SelectionByResponsibleEmployeeID {
    @Element(name = "InclusionExclusionCode")
    var incExclusionCode: String? = null

    @Element(name = "IntervalBoundaryTypeCode")
    var intervalBoundaryTypeCode: Int? = null

    @Element(name = "LowerBoundaryResponsibleEmployeeID")
    var lowerBoundaryEmployeeID: String? = null
}