package com.qwerty.soapapitest.codebase.models.elements

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "SiteLogisticsLotOperationActivity")
data class LotOperationActivity (
    @field:Element(name = "SiteLogisticsLotOperationActivityUUID", required = false)
    var lotOperationActivityUniqueID: String? = null,

    @field:Element(name = "MaterialInput", required = false)
    var materialInput: MaterialInput? = null,

    @field:Element(name = "MaterialOutput", required = false)
    var materialOutput: MaterialOutput? = null
)