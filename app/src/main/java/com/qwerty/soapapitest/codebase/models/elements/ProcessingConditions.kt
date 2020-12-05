package com.qwerty.soapapitest.codebase.models.elements

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

//import org.simpleframework.xml.Element
//import org.simpleframework.xml.Root

//@Root(name = "ProcessingConditions")
@Xml(name = "ProcessingConditions")
class ProcessingConditions {
    @PropertyElement(name = "QueryHitsMaximumNumberValue")
    var maxQueryHits: Int? = null

    @PropertyElement(name = "QueryHitsUnlimitedIndicator")
    var unlimitedQueryHitsIndicator: Boolean? = null

    @PropertyElement(name = "ReturnedQueryHitsNumberValue")
    var returnedQueryHits: Int? = null

    @PropertyElement(name = "MoreHitsAvailableIndicator")
    var moreQueryHitsAvailable: Boolean? = null

    @PropertyElement(name = "LastReturnedObjectID")
    var lastReturnedObjectID: String? = null
}