package com.qwerty.soapapitest.codebase.models.envelopes

import com.qwerty.soapapitest.codebase.models.body.response.TasksByElementsResponse
import org.simpleframework.xml.Root
import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace

@Root(name = "soap-env:Envelope")
@Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "soap-env")
data class GeneralResponseEnvelope @JvmOverloads constructor (
    @field:Element(name = "soap-env:Header", required = false)
    var header: String? = null,

    @field:Element(name = "soap-env:Body", required = false)
    var body: TasksByElementsResponse? = null
)