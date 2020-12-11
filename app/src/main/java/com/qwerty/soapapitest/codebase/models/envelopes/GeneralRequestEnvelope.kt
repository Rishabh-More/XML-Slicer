package com.qwerty.soapapitest.codebase.models.envelopes

import com.qwerty.soapapitest.codebase.models.body.request.TasksByElementsQuery
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.NamespaceList

@Root(name = "soap:Envelope")
@NamespaceList(
    Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "soap"),
    Namespace(reference = "http://sap.com/xi/SAPGlobal20/Global", prefix = "glob")
)
data class GeneralRequestEnvelope @JvmOverloads constructor (
    @field:Element(name = "soap:Header", required = false)
    var header: String? = null,

    @field:Element(name = "soap:Body", required = false)
    var body: TasksByElementsQuery? = null
)