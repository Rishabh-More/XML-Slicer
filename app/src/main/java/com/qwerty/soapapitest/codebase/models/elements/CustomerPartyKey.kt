package com.qwerty.soapapitest.codebase.models.elements

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "CustomerPartyKey")
class CustomerPartyKey {
    @Element(name = "PartyID")
    var partyID: Int? = null
}