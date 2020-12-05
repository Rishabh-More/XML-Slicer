package com.qwerty.soapapitest.codebase.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.qwerty.soapapitest.BuildConfig
import com.qwerty.soapapitest.codebase.models.body.request.TasksByElementsQuery
import com.qwerty.soapapitest.codebase.models.envelopes.GeneralRequestEnvelope
import com.qwerty.soapapitest.codebase.models.envelopes.GeneralResponseEnvelope
import com.qwerty.soapapitest.codebase.network.RetrofitClient.soapService
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Credentials.basic
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit.Builder
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber

const val NO_INTERNET_CONNECTION = "Please check your internet connection and try again"

object RetrofitClient {

    private val BaseClient = OkHttpClient()

    val restService: Api by lazy {
        //TODO Add BaseUrl for MiddleWare
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            BaseClient.newBuilder().addInterceptor(loggingInterceptor)
        }
        Builder().baseUrl(BuildConfig.API_ENDPOINT).addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(
                        MoshiConverterFactory.create()
                ).client(BaseClient).build().create(Api::class.java)
    }

    val soapService: Api by lazy {
        //TODO Manage to find a way to pass url dynamically
        // on every Middleware Api response
        val soapClient = BaseClient.newBuilder().addInterceptor { chain ->
            val base = chain.request()
            val headerBuilder = base.newBuilder()
                    .header("Host", "my348665.sapbydesign.com")
                    .header("Content-Type", "text/xml; charset=utf-8")
                    .header("Accept-Encoding", "gzip, deflate, br")
                    .header("Authorization", basic("_JAVAPOS_0", "Welcome1"))
                    .header("Cookie", "sap-usercontext=sap-client=300")
            val request = headerBuilder.build()
            Timber.e("Request is $request")
            chain.proceed(request)
        }.apply {
            if (BuildConfig.DEBUG) {
                Timber.e("Entered Debug Interceptor logic")
                val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                this.addInterceptor(loggingInterceptor)
            }
        }.build()

        Timber.e("Auth Header: ${basic("_JAVAPOS_0", "Welcome1")}")
        Timber.e("soapClient: Interceptors ${soapClient.interceptors}")
        Builder().baseUrl("https://my348665.sapbydesign.com/sap/bc/srt/scs/sap/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(
                        /*SimpleXmlConverterFactory.create(Persister(AnnotationStrategy()))*/
                        TikXmlConverterFactory.create()
                )
                .client(soapClient).build().create(Api::class.java)
    }
}

suspend fun callTestSoapApi(data: TasksByElementsQuery, onDone: (response: GeneralResponseEnvelope) -> Unit){
    val request = GeneralRequestEnvelope()
    request.body = data
    response(onDone){
        soapService.callSampleSoapApiAsync(request)
    }
}

suspend fun response(
        onDone: (response: GeneralResponseEnvelope) -> Unit,
        responseExec: () -> Deferred<GeneralResponseEnvelope>
){
    CoroutineScope(Dispatchers.IO).launch {
        val resp = try {
            responseExec().await()
        } catch (e: Exception) {
            Timber.e("Exception in Response: ${e.printStackTrace()}")
            GeneralResponseEnvelope()
        }
        onDone(resp)
    }
}