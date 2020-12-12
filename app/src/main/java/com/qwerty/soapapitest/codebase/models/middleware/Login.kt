package com.qwerty.soapapitest.codebase.models.middleware

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
class Login {
    @Json(name = "email")
    var email: String? = null

    @Json(name = "password")
    var password: String? = null

    @Json(name = "deviceId")
    var deviceId: String? = null

    @Json(name = "tenantId")
    var tenantId: String? = null
}