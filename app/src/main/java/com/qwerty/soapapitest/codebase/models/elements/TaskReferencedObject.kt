package com.qwerty.soapapitest.codebase.models.elements

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "SiteLogisticsTaskReferencedObject")
data class TaskReferencedObject @JvmOverloads constructor (
    @field:Element(name = "ReferencedObjectUUID", required = false)
    var objectUnqiueID: String? = null,

    @field:Element(name = "SiteLogisticsLotOperationActivity", required = false)
    var lotOperationActivity: LotOperationActivity? = null
)