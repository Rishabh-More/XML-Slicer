package com.qwerty.soapapitest.codebase.network

import okhttp3.Credentials.basic
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import timber.log.Timber
import java.io.IOException


class AuthenticationInterceptor(user: String?, password: String?) : Interceptor {
    private val credentials: String = basic(user!!, password!!)

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        Timber.e( "Credentials: $credentials")
        val request: Request = chain.request()
        val authenticatedRequest = request.newBuilder()
                .header("Authorization", credentials).build()
        return chain.proceed(authenticatedRequest)
    }

}