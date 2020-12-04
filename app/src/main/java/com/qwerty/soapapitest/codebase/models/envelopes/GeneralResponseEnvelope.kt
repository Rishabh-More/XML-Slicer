package com.qwerty.soapapitest.codebase.models.envelopes

import com.qwerty.soapapitest.codebase.models.body.response.TasksByElementsResponse
import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Xml

//import org.simpleframework.xml.Root
//import org.simpleframework.xml.Element
//import org.simpleframework.xml.Namespace

//@Root(name = "soap-env:Envelope")
//@Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "soap-env")
@Xml(
    name = "soap-env:Envelope",
    writeNamespaces = ["soap-env=http://schemas.xmlsoap.org/soap/envelope/"]
)
class GeneralResponseEnvelope {
    @Element(name = "Header")
    var header: String? = null

    @Element(name = "Body")
    var body: TasksByElementsResponse? = null
}