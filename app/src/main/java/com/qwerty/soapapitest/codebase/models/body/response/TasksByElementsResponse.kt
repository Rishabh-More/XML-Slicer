package com.qwerty.soapapitest.codebase.models.body.response

import org.simpleframework.xml.Root
import org.simpleframework.xml.Element
import com.qwerty.soapapitest.codebase.models.data.TasksByElementsResponseData

@Root(name = "soap-env:Body")
data class TasksByElementsResponse @JvmOverloads constructor(
    @field:Element(name = "n0:SiteLogistcsTaskByElementsResponse_sync", required = false)
    var data: TasksByElementsResponseData? = null
)