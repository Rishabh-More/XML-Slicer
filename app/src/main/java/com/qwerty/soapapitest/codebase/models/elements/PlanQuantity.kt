package com.qwerty.soapapitest.codebase.models.elements

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.TextContent
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "PlanQuantity")
class PlanQuantity {
    @Attribute(name = "unitCode")
    var unitCode: String? = null

    @TextContent
    var value: String? = null
}