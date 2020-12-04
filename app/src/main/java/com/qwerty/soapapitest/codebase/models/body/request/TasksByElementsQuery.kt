package com.qwerty.soapapitest.codebase.models.body.request

import org.simpleframework.xml.Root
import org.simpleframework.xml.Element
import com.qwerty.soapapitest.codebase.models.data.TasksByElementsQueryData

@Root(name = "soap:Body")
class TasksByElementsQuery {
    @field:Element(name = "glob:SiteLogisticsTaskByElementsQuery_sync", required = false)
    var data: TasksByElementsQueryData? = null
}