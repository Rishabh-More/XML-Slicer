package com.qwerty.soapapitest.codebase.models.elements

import org.simpleframework.xml.Root
import org.simpleframework.xml.Element

@Root(name = "SelectionByProcessTypeCode")
data class SelectionByProcessTypeCode @JvmOverloads constructor(
    @field:Element(name = "InclusionExclusionCode", required = false)
    var incExclusionCode: String? = null,

    @field:Element(name = "IntervalBoundaryTypeCode", required = false)
    var intervalBoundaryTypeCode: Int? = null,

    @field:Element(name = "LowerBoundaryProcessTypeCode", required = false)
    var lowerBoundaryTypeCode: Int? = null
)