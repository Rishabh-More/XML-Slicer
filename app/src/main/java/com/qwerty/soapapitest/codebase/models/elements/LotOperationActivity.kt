package com.qwerty.soapapitest.codebase.models.elements

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Xml

//import org.simpleframework.xml.Element
//import org.simpleframework.xml.Root

//@Root(name = "SiteLogisticsLotOperationActivity")
@Xml(name = "SiteLogisticsLotOperationActivity")
class LotOperationActivity {
    @Element(name = "SiteLogisticsLotOperationActivityUUID")
    var lotOperationActivityUniqueID: String? = null

    @Element(name = "MaterialInput")
    var materialInput: MaterialInput? = null

    @Element(name = "MaterialOutput")
    var materialOutput: MaterialOutput? = null
}