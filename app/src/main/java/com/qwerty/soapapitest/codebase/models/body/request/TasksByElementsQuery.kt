package com.qwerty.soapapitest.codebase.models.body.request

import org.simpleframework.xml.Root
//import org.simpleframework.xml.Element
import com.qwerty.soapapitest.codebase.models.data.TasksByElementsQueryData
import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Xml

/*@Root(name = "soap:Body")*/
@Xml(name = "soap:Body")
class TasksByElementsQuery {
    @Element(name = "glob:SiteLogisticsTaskByElementsQuery_sync")
    var data: TasksByElementsQueryData? = null
}