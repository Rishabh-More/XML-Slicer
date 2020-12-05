package com.qwerty.soapapitest.codebase.models.elements

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

//import org.simpleframework.xml.Root
//import org.simpleframework.xml.Element

//@Root(name = "SelectionByProcessTypeCode")
@Xml(name = "SelectionByProcessTypeCode")
class SelectionByProcessTypeCode {
    @PropertyElement(name = "InclusionExclusionCode")
    var incExclusionCode: String? = null

    @PropertyElement(name = "IntervalBoundaryTypeCode")
    var intervalBoundaryTypeCode: Int? = null

    @PropertyElement(name = "LowerBoundaryProcessTypeCode")
    var lowerBoundaryTypeCode: Int? = null
}