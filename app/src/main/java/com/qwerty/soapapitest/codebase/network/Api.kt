package com.qwerty.soapapitest.codebase.network

import com.qwerty.soapapitest.codebase.models.envelopes.GeneralRequestEnvelope
import com.qwerty.soapapitest.codebase.models.envelopes.GeneralResponseEnvelope
import kotlinx.coroutines.Deferred
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*

interface Api {
    @Headers("Content-Type: text/xml; charset=utf-8")
    @POST("querysitelogisticstaskin")
    fun callSampleSoapApiAsync(
            @Body data: String?
    ) : Deferred<String>
}