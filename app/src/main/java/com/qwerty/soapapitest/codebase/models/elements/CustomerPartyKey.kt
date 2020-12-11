package com.qwerty.soapapitest.codebase.models.elements

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "CustomerPartyKey")
data class CustomerPartyKey @JvmOverloads constructor (
    @field:Element(name = "PartyID", required = false)
    var partyID: Int? = null
)