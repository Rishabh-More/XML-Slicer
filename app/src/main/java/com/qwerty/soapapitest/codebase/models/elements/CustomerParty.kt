package com.qwerty.soapapitest.codebase.models.elements

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "CustomerParty")
class CustomerParty {
    @Element(name = "CustomerPartyKey")
    var customerPartyKey: CustomerPartyKey? = null
}