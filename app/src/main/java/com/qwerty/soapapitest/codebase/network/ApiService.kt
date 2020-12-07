package com.qwerty.soapapitest.codebase.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.qwerty.soapapitest.BuildConfig
import com.qwerty.soapapitest.codebase.models.body.request.TasksByElementsQuery
import com.qwerty.soapapitest.codebase.models.elements.ProcessingConditions
import com.qwerty.soapapitest.codebase.models.elements.SelectionByProcessTypeCode
import com.qwerty.soapapitest.codebase.models.elements.SelectionByProcessingStatusCode
import com.qwerty.soapapitest.codebase.models.elements.SelectionByResponsibleEmployeeID
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
import retrofit2.converter.scalars.ScalarsConverterFactory
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
                .addConverterFactory(ScalarsConverterFactory.create())
                /*.addConverterFactory(
                        *//*SimpleXmlConverterFactory.create(Persister(AnnotationStrategy()))*//*
                        TikXmlConverterFactory.create()
                )*/
                .client(soapClient).build().create(Api::class.java)
    }
}

suspend fun callTestSoapApi(onDone: (response: String) -> Unit){
    /*val request = GeneralRequestEnvelope()
    request.body = data*/
    val requestBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" +
            "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:glob=\"http://sap.com/xi/SAPGlobal20/Global\">\r\n" +
            "   <soap:Header/>\r\n" +
            "   <soap:Body>\r\n" +
            "      <glob:SiteLogisticsTaskByElementsQuery_sync>\r\n" +
            "        <SiteLogisticsTaskSelectionByElements>\r\n" +
            "         <SelectionByProcessTypeCode>\r\n" +
            "            <InclusionExclusionCode>I</InclusionExclusionCode>\r\n" +
            "            <IntervalBoundaryTypeCode>1</IntervalBoundaryTypeCode>\r\n" +
            "            <LowerBoundaryProcessTypeCode>1</LowerBoundaryProcessTypeCode>\r\n" +
            "         </SelectionByProcessTypeCode>\r\n\t\t" +
            " <SelectionByResponsibleEmployeeID>\r\n" +
            "            <InclusionExclusionCode>I</InclusionExclusionCode>\r\n" +
            "            <IntervalBoundaryTypeCode>1</IntervalBoundaryTypeCode>\r\n" +
            "            <LowerBoundaryResponsibleEmployeeID>E0005</LowerBoundaryResponsibleEmployeeID>\r\n" +
            "         </SelectionByResponsibleEmployeeID>\r\n\t\t" +
            " <SelectionByProcessingStatusCode>\r\n\t\t" +
            "    <InclusionExclusionCode>I</InclusionExclusionCode>\r\n\t\t\t" +
            "<IntervalBoundaryTypeCode>1</IntervalBoundaryTypeCode>\r\n" +
            "            <LowerBoundarySiteLogisticsProcessingStatusCode>1</LowerBoundarySiteLogisticsProcessingStatusCode>\r\n" +
            "         </SelectionByProcessingStatusCode>\r\n\t\t" +
            "</SiteLogisticsTaskSelectionByElements>\r\n" +
            "        <ProcessingConditions>\r\n" +
            "            <QueryHitsMaximumNumberValue>2</QueryHitsMaximumNumberValue>\r\n" +
            "            <QueryHitsUnlimitedIndicator>false</QueryHitsUnlimitedIndicator>\r\n" +
            "        </ProcessingConditions>\r\n" +
            "      </glob:SiteLogisticsTaskByElementsQuery_sync>\r\n" +
            "   </soap:Body>\r\n" +
            "</soap:Envelope>"
    response(onDone){
        soapService.callSampleSoapApiAsync(requestBody)
    }
}

suspend fun response(
        onDone: (response: String) -> Unit,
        responseExec: () -> Deferred<String>
){
    CoroutineScope(Dispatchers.IO).launch {
        val resp = try {
            responseExec().await()
        } catch (e: Exception) {
            Timber.e("Exception in Response: ${e.printStackTrace()}")
            //GeneralResponseEnvelope()
        }
        onDone(resp as String)
    }
}