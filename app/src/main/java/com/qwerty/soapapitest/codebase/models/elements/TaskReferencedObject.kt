package com.qwerty.soapapitest.codebase.models.elements

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Xml

//import org.simpleframework.xml.Element
//import org.simpleframework.xml.Root

//@Root(name = "SiteLogisticsTaskReferencedObject")
@Xml(name = "SiteLogisticsTaskReferencedObject")
class TaskReferencedObject {
    @Element(name = "ReferencedObjectUUID")
    var objectUnqiueID: String? = null

    @Element(name = "SiteLogisticsLotOperationActivity")
    var lotOperationActivity: LotOperationActivity? = null

}