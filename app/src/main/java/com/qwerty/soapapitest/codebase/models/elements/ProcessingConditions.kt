package com.qwerty.soapapitest.codebase.models.elements

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Xml

//import org.simpleframework.xml.Element
//import org.simpleframework.xml.Root

//@Root(name = "ProcessingConditions")
@Xml(name = "ProcessingConditions")
class ProcessingConditions {
    @Element(name = "QueryHitsMaximumNumberValue")
    var maxQueryHits: Int? = null

    @Element(name = "QueryHitsUnlimitedIndicator")
    var unlimitedQueryHitsIndicator: Boolean? = null

    @Element(name = "ReturnedQueryHitsNumberValue")
    var returnedQueryHits: Int? = null

    @Element(name = "MoreHitsAvailableIndicator")
    var moreQueryHitsAvailable: Boolean? = null

    @Element(name = "LastReturnedObjectID")
    var lastReturnedObjectID: String? = null
}