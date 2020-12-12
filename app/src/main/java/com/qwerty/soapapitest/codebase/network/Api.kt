package com.qwerty.soapapitest.codebase.network

import com.qwerty.soapapitest.codebase.models.middleware.Login
import com.qwerty.soapapitest.codebase.models.middleware.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST
import kotlinx.coroutines.Deferred
import com.qwerty.soapapitest.codebase.models.soapservice.envelopes.GeneralRequestEnvelope
import com.qwerty.soapapitest.codebase.models.soapservice.envelopes.GeneralResponseEnvelope
import retrofit2.Call
import retrofit2.http.Headers

interface Api {

    @POST("api/app/login")
    fun callDemoLoginApiAsync(@Body data: Login) : Call<LoginResponse>

    @Headers("Content-Type: text/xml; charset=utf-8")
    @POST("querysitelogisticstaskin")
    fun callSampleSoapApiAsync(
            @Body data: GeneralRequestEnvelope
    ) : Call<GeneralResponseEnvelope>
}