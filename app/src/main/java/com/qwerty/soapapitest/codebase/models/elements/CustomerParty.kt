package com.qwerty.soapapitest.codebase.models.elements

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

//import org.simpleframework.xml.Element
//import org.simpleframework.xml.Root

//@Root(name = "CustomerParty")
@Xml(name = "CustomerParty")
class CustomerParty {
    @Element(name = "CustomerPartyKey")
    var customerPartyKey: CustomerPartyKey? = null

    @PropertyElement(name = "CustomerPartyName")
    var customerPartyName: String? = null
}