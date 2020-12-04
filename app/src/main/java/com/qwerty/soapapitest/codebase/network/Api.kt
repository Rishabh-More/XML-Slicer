package com.qwerty.soapapitest.codebase.network

import com.qwerty.soapapitest.codebase.models.body.request.TasksByElementsQuery
import com.qwerty.soapapitest.codebase.models.body.response.TasksByElementsResponse
import retrofit2.http.Url
import retrofit2.http.Body
import retrofit2.http.POST
import kotlinx.coroutines.Deferred
import com.qwerty.soapapitest.codebase.models.envelopes.GeneralRequestEnvelope
import com.qwerty.soapapitest.codebase.models.envelopes.GeneralResponseEnvelope

interface Api {
    @POST("querysitelogisticstaskin")
    fun callSampleSoapApiAsync(
            @Body data: GeneralRequestEnvelope
    ) : Deferred<GeneralResponseEnvelope>
}