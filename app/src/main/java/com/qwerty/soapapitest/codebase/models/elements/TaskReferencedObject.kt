package com.qwerty.soapapitest.codebase.models.elements

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "SiteLogisticsTaskReferencedObject")
class TaskReferencedObject {
    @Element(name = "ReferencedObjectUUID")
    var objectUnqiueID: String? = null

    @Element(name = "SiteLogisticsLotOperationActivity")
    var lotOperationActivity: LotOperationActivity? = null

}