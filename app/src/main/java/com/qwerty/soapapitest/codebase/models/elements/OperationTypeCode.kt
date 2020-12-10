package com.qwerty.soapapitest.codebase.models.elements

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.TextContent
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "OperationTypeCode")
class OperationTypeCode {
    @Attribute(name = "listAgencyID")
    var listAgencyID: String? = null

    @TextContent
    var value: String? = null
}