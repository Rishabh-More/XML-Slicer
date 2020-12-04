package com.qwerty.soapapitest.codebase.models.elements

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "SiteLogisticsLotOperationActivity")
class LotOperationActivity {
    @Element(name = "SiteLogisticsLotOperationActivityUUID")
    var lotOperationActivityUniqueID: String? = null

    @Element(name = "MaterialInput")
    var materialInput: MaterialInput? = null

    @Element(name = "MaterialOutput")
    var materialOutput: MaterialOutput? = null
}