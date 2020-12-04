package com.qwerty.soapapitest.codebase.models.envelopes

import com.qwerty.soapapitest.codebase.models.body.response.TasksByElementsResponse
import org.simpleframework.xml.Root
import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace

@Root(name = "soap-env:Envelope")
@Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "soap-env")
class GeneralResponseEnvelope {
    @Element(name = "Header", required = false)
    var header: String? = null

    @Element(name = "Body", required = false)
    var body: TasksByElementsResponse? = null
}