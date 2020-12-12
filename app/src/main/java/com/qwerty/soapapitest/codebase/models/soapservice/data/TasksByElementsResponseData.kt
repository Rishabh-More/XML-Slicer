package com.qwerty.soapapitest.codebase.models.soapservice.data

import org.simpleframework.xml.*
import com.qwerty.soapapitest.codebase.models.soapservice.elements.SiteLogisticsTask
import com.qwerty.soapapitest.codebase.models.soapservice.elements.ProcessingConditions

@Root(name = "n0:SiteLogistcsTaskByElementsResponse_sync")
@NamespaceList(
    Namespace(reference = "http://sap.com/xi/SAPGlobal20/Global", prefix = "n0"),
    Namespace(reference = "urn:sap.com:proxy:KY1:/1SAI/TASCB109484409CA11A7C74:804", prefix = "prx")
)
@Order(elements = ["SiteLogisticsTask","ProcessingConditions"])
data class TasksByElementsResponseData @JvmOverloads constructor (
    @field:ElementList(name = "SiteLogisticsTask", required = false)
    var tasks: List<SiteLogisticsTask>? = null,

    @field:Element(name = "ProcessingConditions", required = false)
    var processingConditions: ProcessingConditions? = null
)