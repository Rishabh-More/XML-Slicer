package com.qwerty.soapapitest.codebase.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.qwerty.soapapitest.BuildConfig
import com.qwerty.soapapitest.codebase.models.body.request.TasksByElementsQuery
import com.qwerty.soapapitest.codebase.models.envelopes.GeneralRequestEnvelope
import com.qwerty.soapapitest.codebase.models.envelopes.GeneralResponseEnvelope
import com.qwerty.soapapitest.codebase.network.RetrofitClient.soapService
import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.*
import okhttp3.Credentials.basic
import okhttp3.RequestBody.create
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit.Builder
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import java.io.IOException


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
        Builder().baseUrl(BuildConfig.API_ENDPOINT).addCallAdapterFactory(
            CoroutineCallAdapterFactory()
        )
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
        //Timber.e("soapClient: Interceptors $soapClient")
        Builder().baseUrl("https://my348665.sapbydesign.com/sap/bc/srt/scs/sap/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(
                    //SimpleXmlConverterFactory.create(Persister(AnnotationStrategy()))
                    TikXmlConverterFactory.create(
                        TikXml.Builder().exceptionOnUnreadXml(false).build()
                    )
                )
                .client(soapClient).build().create(Api::class.java)
    }
}

suspend fun callTestSoapApi(
    data: TasksByElementsQuery,
    onDone: (response: GeneralResponseEnvelope) -> Unit
){

    /**String Method with OkHttp3 */
    /*val client = OkHttpClient().newBuilder()
        .build()
    val mediaType: MediaType? = MediaType.parse("text/xml; charset:utf-8")
    val body: RequestBody = create(
        mediaType,
        "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" +
                "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:glob=\"http://sap.com/xi/SAPGlobal20/Global\">\r\n" +
                "   <soap:Header/>\r\n" +
                "   <soap:Body>\r\n" +
                "      <glob:SiteLogisticsTaskByElementsQuery_sync>\r\n" +
                "        <SiteLogisticsTaskSelectionByElements>\r\n" +
                "         <SelectionByProcessTypeCode>\r\n" +
                "            <InclusionExclusionCode>I</InclusionExclusionCode>\r\n" +
                "            <IntervalBoundaryTypeCode>1</IntervalBoundaryTypeCode>\r\n" +
                "            <LowerBoundaryProcessTypeCode>1</LowerBoundaryProcessTypeCode>\r\n" +
                "         </SelectionByProcessTypeCode>\r\n" +
                "\t\t <SelectionByResponsibleEmployeeID>\r\n" +
                "            <InclusionExclusionCode>I</InclusionExclusionCode>\r\n" +
                "            <IntervalBoundaryTypeCode>1</IntervalBoundaryTypeCode>\r\n " +
                "           <LowerBoundaryResponsibleEmployeeID>E0005</LowerBoundaryResponsibleEmployeeID>\r\n" +
                "         </SelectionByResponsibleEmployeeID>\r\n" +
                "         <SelectionByResponsibleEmployeeID>\r\n" +
                "            <InclusionExclusionCode>E</InclusionExclusionCode>\r\n" +
                "            <IntervalBoundaryTypeCode>1</IntervalBoundaryTypeCode>\r\n" +
                "            <LowerBoundaryResponsibleEmployeeID>\"*\"</LowerBoundaryResponsibleEmployeeID>\r\n" +
                "         </SelectionByResponsibleEmployeeID>\r\n" +
                "\t\t <SelectionByProcessingStatusCode>\r\n" +
                "\t\t    <InclusionExclusionCode>I</InclusionExclusionCode>\r\n" +
                "\t\t\t<IntervalBoundaryTypeCode>1</IntervalBoundaryTypeCode>\r\n" +
                "            <LowerBoundarySiteLogisticsProcessingStatusCode>1</LowerBoundarySiteLogisticsProcessingStatusCode>\r\n" +
                "         </SelectionByProcessingStatusCode>\r\n" +
                "\t\t <SelectionByProcessingStatusCode>\r\n" +
                "\t\t    <InclusionExclusionCode>I</InclusionExclusionCode>\r\n" +
                "\t\t\t<IntervalBoundaryTypeCode>1</IntervalBoundaryTypeCode>\r\n" +
                "            <LowerBoundarySiteLogisticsProcessingStatusCode>2</LowerBoundarySiteLogisticsProcessingStatusCode>\r\n" +
                "         </SelectionByProcessingStatusCode>\r\n" +
                "\t\t <SelectionByProcessingStatusCode>\r\n" +
                "\t\t    <InclusionExclusionCode>I</InclusionExclusionCode>\r\n" +
                "\t\t\t<IntervalBoundaryTypeCode>1</IntervalBoundaryTypeCode>\r\n" +
                "            <LowerBoundarySiteLogisticsProcessingStatusCode>3</LowerBoundarySiteLogisticsProcessingStatusCode>\r\n" +
                "         </SelectionByProcessingStatusCode>\r\n" +
                "\t\t</SiteLogisticsTaskSelectionByElements>\r\n" +
                "        <ProcessingConditions>\r\n" +
                "            <QueryHitsMaximumNumberValue>1</QueryHitsMaximumNumberValue>\r\n" +
                "            <QueryHitsUnlimitedIndicator>false</QueryHitsUnlimitedIndicator>\r\n" +
                "        </ProcessingConditions>\r\n" +
                "      </glob:SiteLogisticsTaskByElementsQuery_sync>\r\n" +
                "   </soap:Body>\r\n" +
                "</soap:Envelope>"
    )
    val stringSoapRequest: Request = Request.Builder()
        .url("https://my348665.sapbydesign.com/sap/bc/srt/scs/sap/querysitelogisticstaskin")
        .method("POST", body)
        .addHeader("Content-Type", "text/xml; charset=utf-8")
        .addHeader("Authorization", "Basic X0pBVkFQT1NfMDpXZWxjb21lMQ==")
        .addHeader("Cookie", "sap-usercontext=sap-client=300")
        .build()
    val call: Call = client.newCall(stringSoapRequest)
    call.enqueue(object: Callback{
        override fun onResponse(call: Call, response: okhttp3.Response) {
            try{
                val status = response.code
                val body: ResponseBody? = response.body
                Timber.e("OkHttp3 Response Object: $response")
                Timber.e("resp body source: ${body?.source()?.buffer?.snapshot()?.utf8()}")
                Timber.e("Response Body from OkHttp3: Status: isSuccessful? ${response.isSuccessful} $status Body: ${body?.string()} Content-Type: ${response.body?.contentType()}")
            } catch (e: Exception){
                e.printStackTrace()
            }
        }

        override fun onFailure(call: Call, e: IOException) {
            TODO("Not yet implemented")
        }
    })*/

    /** Here I'll Define which class type will be used as Body in the General Request*/
    val request = GeneralRequestEnvelope()
    Timber.e("request before appending body: ${request.body}")
    request.body = data
    Timber.e("request after appending body: ${request.body}")
    response(onDone){
        soapService.callSampleSoapApiAsync(request)
    }
    /*soapService.callSampleSoapApiAsync(request).enqueue(object : Callback<GeneralResponseEnvelope> {
        override fun onResponse(call: Call<GeneralResponseEnvelope>, response: Response<GeneralResponseEnvelope>) {
            Timber.e("Api Response from onResponse: ${response.body()}")
        }

        override fun onFailure(call: Call<GeneralResponseEnvelope>, t: Throwable) {
            t.printStackTrace()
        }
    })*/
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
