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
class GeneralRequestEnvelope {
    @field:Element(name = "Header")
    var header: String? = null

    @field:Element(name = "Body")
    var body: TasksByElementsQuery? = null
}