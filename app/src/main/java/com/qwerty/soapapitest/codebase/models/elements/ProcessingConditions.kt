package com.qwerty.soapapitest.codebase.models.elements

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "ProcessingConditions")
data class ProcessingConditions @JvmOverloads constructor (
    @field:Element(name = "QueryHitsMaximumNumberValue", required = false)
    var maxQueryHits: Int? = null,

    @field:Element(name = "QueryHitsUnlimitedIndicator", required = false)
    var unlimitedQueryHitsIndicator: Boolean? = null,

    @field:Element(name = "ReturnedQueryHitsNumberValue", required = false)
    var returnedQueryHits: Int? = null,

    @field:Element(name = "MoreHitsAvailableIndicator", required = false)
    var moreQueryHitsAvailable: Boolean? = null,

    @field:Element(name = "LastReturnedObjectID", required = false)
    var lastReturnedObjectID: String? = null
)