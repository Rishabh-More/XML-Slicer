package com.qwerty.soapapitest.codebase.network

import com.qwerty.soapapitest.codebase.models.body.request.TasksByElementsQuery
import com.qwerty.soapapitest.codebase.models.envelopes.GeneralRequestEnvelope
import com.qwerty.soapapitest.codebase.models.envelopes.GeneralResponseEnvelope
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface Api {
    @Headers("Content-Type: text/xml; charset=utf-8")
    @POST("querysitelogisticstaskin")
    fun callSampleSoapApiAsync(
            @Body data: GeneralRequestEnvelope
    ) : Deferred<GeneralResponseEnvelope>
}