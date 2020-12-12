package com.qwerty.soapapitest.codebase.models.soapservice.elements

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "SelectionByProcessingStatusCode")
data class SelectionByProcessingStatusCode @JvmOverloads constructor (
    @field:Element(name = "InclusionExclusionCode", required = false)
    var incExclusionCode: String? = null,

    @field:Element(name = "IntervalBoundaryTypeCode", required = false)
    var intervalBoundaryTypeCode: Int? = null,

    @field:Element(name = "LowerBoundarySiteLogisticsProcessingStatusCode", required = false)
    var lowerBoundaryProcessingStatusCode: Int? = null
)