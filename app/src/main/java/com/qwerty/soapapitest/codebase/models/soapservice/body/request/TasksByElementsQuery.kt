package com.qwerty.soapapitest.codebase.models.soapservice.body.request

import org.simpleframework.xml.Root
import org.simpleframework.xml.Element
import com.qwerty.soapapitest.codebase.models.soapservice.data.TasksByElementsQueryData

@Root(name = "soap:Body")
data class TasksByElementsQuery @JvmOverloads constructor (
    @field:Element(name = "glob:SiteLogisticsTaskByElementsQuery_sync", required = false)
    var data: TasksByElementsQueryData? = null
)