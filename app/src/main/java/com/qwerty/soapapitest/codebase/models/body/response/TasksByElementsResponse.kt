package com.qwerty.soapapitest.codebase.models.body.response

import org.simpleframework.xml.Root
import org.simpleframework.xml.Element
import com.qwerty.soapapitest.codebase.models.data.TasksByElementsResponseData

@Root(name = "soap-env:Body")
class TasksByElementsResponse {
    @Element(name = "n0:SiteLogistcsTaskByElementsResponse_sync")
    var data: TasksByElementsResponseData? = null
}