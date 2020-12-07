package com.qwerty.soapapitest.codebase.models.envelopes

import com.qwerty.soapapitest.codebase.models.body.request.TasksByElementsQuery
import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Xml

/*import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.NamespaceList*/

/*@Root(name = "soap:Envelope")
@NamespaceList(
    Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "soap"),
    Namespace(reference = "http://sap.com/xi/SAPGlobal20/Global", prefix = "glob")
)*/
@Xml(
    name = "soap:Envelope",
    writeNamespaces = [
        "soap=http://schemas.xmlsoap.org/soap/envelope/",
        "glob=http://sap.com/xi/SAPGlobal20/Global"
    ]
)
class GeneralRequestEnvelope {
    @Element(name = "soap:Header")
    var header: String? = null

    @Element(name = "soap:Body")
    var body: TasksByElementsQuery? = null
}