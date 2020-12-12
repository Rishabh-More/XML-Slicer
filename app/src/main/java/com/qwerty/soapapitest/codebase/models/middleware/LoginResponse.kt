package com.qwerty.soapapitest.codebase.models.middleware

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
class LoginResponse {
    @Json(name = "status")
    var status: Boolean? = null

    @Json(name = "message")
    var message: String? = null

    /*@Json(name = "data")
    var data: String? = null*/
}