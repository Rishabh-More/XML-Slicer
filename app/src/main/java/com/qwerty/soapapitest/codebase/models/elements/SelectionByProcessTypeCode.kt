package com.qwerty.soapapitest.codebase.models.elements

import org.simpleframework.xml.Root
import org.simpleframework.xml.Element

@Root(name = "SelectionByProcessTypeCode")
class SelectionByProcessTypeCode {
    @Element(name = "InclusionExclusionCode")
    var incExclusionCode: String? = null

    @Element(name = "IntervalBoundaryTypeCode")
    var intervalBoundaryTypeCode: Int? = null

    @Element(name = "LowerBoundaryProcessTypeCode")
    var lowerBoundaryTypeCode: Int? = null
}