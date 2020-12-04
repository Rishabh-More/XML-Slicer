package com.qwerty.soapapitest.codebase.models.elements

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Xml

//import org.simpleframework.xml.Element
//import org.simpleframework.xml.Root

//@Root(name = "CustomerPartyKey")
@Xml(name = "CustomerPartyKey")
class CustomerPartyKey {
    @Element(name = "PartyID")
    var partyID: Int? = null
}