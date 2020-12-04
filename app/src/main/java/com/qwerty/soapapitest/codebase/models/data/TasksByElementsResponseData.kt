package com.qwerty.soapapitest.codebase.models.data

//import org.simpleframework.xml.*
import com.qwerty.soapapitest.codebase.models.elements.SiteLogisticsTask
import com.qwerty.soapapitest.codebase.models.elements.ProcessingConditions
import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Xml

//@Root(name = "n0:SiteLogistcsTaskByElementsResponse_sync")
/*@NamespaceList(
    Namespace(reference = "http://sap.com/xi/SAPGlobal20/Global", prefix = "n0"),
    Namespace(reference = "urn:sap.com:proxy:KY1:/1SAI/TASCB109484409CA11A7C74:804", prefix = "prx")
)*/
@Xml(
    name = "n0:SiteLogistcsTaskByElementsResponse_sync",
    writeNamespaces = [
        "n0=http://sap.com/xi/SAPGlobal20/Global",
        "prx=urn:sap.com:proxy:KY1:/1SAI/TASCB109484409CA11A7C74:804"
    ]
)
class TasksByElementsResponseData {
    @Element(name = "SiteLogisticsTask")
    var tasks: List<SiteLogisticsTask>? = null

    @Element(name = "ProcessingConditions")
    var processingConditions: ProcessingConditions? = null
}