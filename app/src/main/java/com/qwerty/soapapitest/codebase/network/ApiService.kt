package com.qwerty.soapapitest.codebase.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.qwerty.soapapitest.BuildConfig
import com.qwerty.soapapitest.codebase.models.middleware.Login
import com.qwerty.soapapitest.codebase.models.middleware.LoginResponse
import com.qwerty.soapapitest.codebase.models.soapservice.body.request.TasksByElementsQuery
import com.qwerty.soapapitest.codebase.models.soapservice.envelopes.GeneralRequestEnvelope
import com.qwerty.soapapitest.codebase.models.soapservice.envelopes.GeneralResponseEnvelope
import com.qwerty.soapapitest.codebase.network.RetrofitClient.restService
import com.qwerty.soapapitest.codebase.network.RetrofitClient.soapService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Credentials.basic
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit.Builder
import retrofit2.converter.moshi.MoshiConverterFactory
import org.simpleframework.xml.core.Persister
import org.simpleframework.xml.convert.AnnotationStrategy
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import timber.log.Timber

const val NO_INTERNET_CONNECTION = "Please check your internet connection and try again"

object RetrofitClient {
    val BaseClient = OkHttpClient()

    val restService: Api by lazy {
        //TODO Add BaseUrl for MiddleWare
        val restClient = BaseClient.newBuilder().addInterceptor { chain ->
            val base = chain.request()
            val headerBuilder = base.newBuilder()
            val request = headerBuilder.build()
            chain.proceed(request)
        }.apply {
            if (BuildConfig.DEBUG) {
                val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                this.addInterceptor(loggingInterceptor)
            }
        }.build()
        Builder().baseUrl(BuildConfig.API_ENDPOINT).addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(
                MoshiConverterFactory.create()
            ).client(restClient).build().create(Api::class.java)
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
        Builder().baseUrl("https://my348665.sapbydesign.com/sap/bc/srt/scs/sap/")
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(SimpleXmlConverterFactory.create(Persister(AnnotationStrategy())))
            .client(soapClient).build().create(Api::class.java)
    }
}

suspend fun callDemoLogin(body: Login){
    restService.callDemoLoginApiAsync(body).enqueue(object: Callback<LoginResponse>{
        override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
            Timber.e("Login Response: ${response.body()?.message}")
        }

        override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
            t.printStackTrace()
        }
    })
}

suspend fun callTestSoapApi(data: TasksByElementsQuery,onDone: (response: GeneralResponseEnvelope) -> Unit){
    val request = GeneralRequestEnvelope()
    Timber.e("request before appending body: ${request.body}")
    request.body = data
    Timber.e("request after appending body: ${request.body}")
    soapService.callSampleSoapApiAsync(request).enqueue(object: Callback<GeneralResponseEnvelope>{
        override fun onResponse(
            call: Call<GeneralResponseEnvelope>,
            response: Response<GeneralResponseEnvelope>
        ) {
            Timber.e("Soap Response Headers: ${response.headers()}")
            Timber.e("Soap Response Body: ${response.body()}")
            Timber.e("Soap Raw Response: ${response.raw()}")
        }

        override fun onFailure(call: Call<GeneralResponseEnvelope>, t: Throwable) {
            t.printStackTrace()
        }
    })
    /*response(onDone){
        soapService.callSampleSoapApiAsync(request)
    }*/
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