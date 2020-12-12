package com.qwerty.soapapitest.codebase.models.soapservice.elements

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "CustomerParty")
data class CustomerParty @JvmOverloads constructor (
    @field:Element(name = "CustomerPartyKey", required = false)
    var customerPartyKey: CustomerPartyKey? = null,

    @field:Element(name = "CustomerPartyName", required = false)
    var customerPartyName: String? = null
)