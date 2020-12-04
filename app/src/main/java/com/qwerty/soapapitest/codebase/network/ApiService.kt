package com.qwerty.soapapitest.codebase.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.qwerty.soapapitest.BuildConfig
import com.qwerty.soapapitest.codebase.models.body.request.TasksByElementsQuery
import com.qwerty.soapapitest.codebase.models.body.response.TasksByElementsResponse
import com.qwerty.soapapitest.codebase.models.envelopes.GeneralRequestEnvelope
import com.qwerty.soapapitest.codebase.models.envelopes.GeneralResponseEnvelope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit.Builder
import retrofit2.converter.moshi.MoshiConverterFactory
import org.simpleframework.xml.core.Persister
import org.simpleframework.xml.convert.AnnotationStrategy
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

const val NO_INTERNET_CONNECTION = "Please check your internet connection and try again"
val BaseClient = OkHttpClient()

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
    if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        BaseClient.newBuilder().addInterceptor(loggingInterceptor)
    }
    BaseClient.newBuilder().addInterceptor { chain ->
        val base = chain.request()
        val headerBuilder = base.newBuilder().header("Content-Type","text/xml; charset=utf-8")
        val request = headerBuilder.build()
        chain.proceed(request)
    }.addInterceptor(AuthenticationInterceptor("_JAVAPOS_0","Welcome1"))
    Builder().baseUrl("https://my348665.sapbydesign.com/sap/bc/srt/scs/sap/")
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addConverterFactory(SimpleXmlConverterFactory.create(Persister(AnnotationStrategy())))
        .client(BaseClient).build().create(Api::class.java)
}

suspend fun callTestSoapApi(data: TasksByElementsQuery,onDone: (response: GeneralResponseEnvelope) -> Unit){
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
            e.printStackTrace()
            GeneralResponseEnvelope()
        }
        onDone(resp)
    }
}