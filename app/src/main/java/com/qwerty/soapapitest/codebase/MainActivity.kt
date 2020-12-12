package com.qwerty.soapapitest.codebase

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.qwerty.soapapitest.base.BaseActivity
import com.qwerty.soapapitest.codebase.models.middleware.Login
import com.qwerty.soapapitest.codebase.models.soapservice.body.request.TasksByElementsQuery
import com.qwerty.soapapitest.codebase.models.soapservice.data.TasksByElementsQueryData
import com.qwerty.soapapitest.codebase.models.soapservice.elements.*
import com.qwerty.soapapitest.codebase.models.soapservice.envelopes.GeneralResponseEnvelope
import com.qwerty.soapapitest.codebase.network.callDemoLogin
import com.qwerty.soapapitest.codebase.network.callTestSoapApi
import com.qwerty.soapapitest.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get
import org.simpleframework.xml.Serializer
import org.simpleframework.xml.core.Persister
import timber.log.Timber

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Timber.tag("MAIN_ACTIVITY")

        binding.mainLoginButton.setOnClickListener {
            lifecycleScope.launch(Dispatchers.Main){
                val  login = get<Login>()
                login.email = "EXT1002"
                login.password = "Percipere@2019"
                login.deviceId = "12345"
                login.tenantId = "999"
                callDemoLogin(login)
            }
        }

        binding.mainActionButton.setOnClickListener {

            val serializer: Serializer = Persister()
            val response = serializer.read(GeneralResponseEnvelope::class.java,"<soap-env:Envelope xmlns:soap-env=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                    "    <soap-env:Header/>\n" +
                    "    <soap-env:Body>\n" +
                    "        <n0:SiteLogistcsTaskByElementsResponse_sync xmlns:n0=\"http://sap.com/xi/SAPGlobal20/Global\" xmlns:prx=\"urn:sap.com:proxy:KY1:/1SAI/TASCB109484409CA11A7C74:804\">\n" +
                    "            <SiteLogisticsTask>\n" +
                    "                <SiteLogisticsTaskID>187</SiteLogisticsTaskID>\n" +
                    "                <SiteLogisticsTaskUUID>00163e03-0680-1ee2-87a3-9016e158eae2</SiteLogisticsTaskUUID>\n" +
                    "                <OperationTypeCode listAgencyID=\" \">13</OperationTypeCode>\n" +
                    "                <BusinessTransactionDocumentReferenceID>319</BusinessTransactionDocumentReferenceID>\n" +
                    "                <SiteLogisticsTaskReferencedObject>\n" +
                    "                    <ReferencedObjectUUID>00163e03-0680-1ee2-87a3-9016e1590ae2</ReferencedObjectUUID>\n" +
                    "                    <SiteLogisticsLotOperationActivity>\n" +
                    "                        <SiteLogisticsLotOperationActivityUUID>00163e03-0680-1ee2-87a3-8ff4ec74cae2</SiteLogisticsLotOperationActivityUUID>\n" +
                    "                        <MaterialInput>\n" +
                    "                            <SiteLogisticsLotMaterialInputUUID>00163e03-0680-1ee2-87a3-8ff4ec750ae2</SiteLogisticsLotMaterialInputUUID>\n" +
                    "                            <ProductID>P110310</ProductID>\n" +
                    "                            <ProductDescription>Brown Coal Briquette, 1 palette</ProductDescription>\n" +
                    "                            <PlanQuantity unitCode=\"XPX\">21.0</PlanQuantity>\n" +
                    "                            <OpenQuantity unitCode=\"XPX\">0.0</OpenQuantity>\n" +
                    "                            <TotalConfirmedQuantity unitCode=\"XPX\">21.0</TotalConfirmedQuantity>\n" +
                    "                            <LineItemID>1</LineItemID>\n" +
                    "                            <MaterialDeviationStatusCode>1</MaterialDeviationStatusCode>\n" +
                    "                        </MaterialInput>\n" +
                    "                        <MaterialOutput>\n" +
                    "                            <SiteLogisticsLotMaterialOutputUUID>00163e03-0680-1ee2-87a3-8ff4ec752ae2</SiteLogisticsLotMaterialOutputUUID>\n" +
                    "                            <TargetLogisticsAreaID>P1100-10</TargetLogisticsAreaID>\n" +
                    "                            <ProductID>P110310</ProductID>\n" +
                    "                            <ProductDescription>Brown Coal Briquette, 1 palette</ProductDescription>\n" +
                    "                            <PlanQuantity unitCode=\"XPX\">21.0</PlanQuantity>\n" +
                    "                            <OpenQuantity unitCode=\"XPX\">0.0</OpenQuantity>\n" +
                    "                            <TotalConfirmedQuantity unitCode=\"XPX\">21.0</TotalConfirmedQuantity>\n" +
                    "                            <MaterialDeviationStatusCode>1</MaterialDeviationStatusCode>\n" +
                    "                            <LineItemID>1</LineItemID>\n" +
                    "                        </MaterialOutput>\n" +
                    "                    </SiteLogisticsLotOperationActivity>\n" +
                    "                </SiteLogisticsTaskReferencedObject>\n" +
                    "                <CustomerParty>\n" +
                    "                    <CustomerPartyKey>\n" +
                    "                        <PartyID>1000</PartyID>\n" +
                    "                    </CustomerPartyKey>\n" +
                    "                </CustomerParty>\n" +
                    "                <EarliestExecutionStartDate>2012-10-23T14:18:23Z</EarliestExecutionStartDate>\n" +
                    "                <LatestExecutionEndDate>2012-10-23T14:33:00Z</LatestExecutionEndDate>\n" +
                    "            </SiteLogisticsTask>\n" +
                    "            <ProcessingConditions>\n" +
                    "                <ReturnedQueryHitsNumberValue>1</ReturnedQueryHitsNumberValue>\n" +
                    "                <MoreHitsAvailableIndicator>true</MoreHitsAvailableIndicator>\n" +
                    "                <LastReturnedObjectID>00163E0306801EE287A39016E158EAE2</LastReturnedObjectID>\n" +
                    "            </ProcessingConditions>\n" +
                    "        </n0:SiteLogistcsTaskByElementsResponse_sync>\n" +
                    "    </soap-env:Body>\n" +
                    "</soap-env:Envelope>")
            Timber.e("Deserialized Xml: $response")

            /*lifecycleScope.launch(Dispatchers.Main){
                val selectionByProcessTypeCode = get<SelectionByProcessTypeCode>()
                selectionByProcessTypeCode.incExclusionCode = "I"
                selectionByProcessTypeCode.intervalBoundaryTypeCode = 1
                selectionByProcessTypeCode.lowerBoundaryTypeCode = 1
                val employee1 = get<SelectionByResponsibleEmployeeID>()
                employee1.incExclusionCode = "I"
                employee1.intervalBoundaryTypeCode = 1
                employee1.lowerBoundaryEmployeeID = "E0005"
                val employee2 = get<SelectionByResponsibleEmployeeID>()
                employee2.incExclusionCode = "E"
                employee2.intervalBoundaryTypeCode = 1
                employee2.lowerBoundaryEmployeeID = "\"*\""
                val responsibleEmployees = ArrayList<SelectionByResponsibleEmployeeID>()
                responsibleEmployees.add(employee1)
                responsibleEmployees.add(employee2)
                val processingStatusCode1 = get<SelectionByProcessingStatusCode>()
                processingStatusCode1.incExclusionCode = "I"
                processingStatusCode1.intervalBoundaryTypeCode = 1
                processingStatusCode1.lowerBoundaryProcessingStatusCode = 1
                val processingStatusCode2 = get<SelectionByProcessingStatusCode>()
                processingStatusCode2.incExclusionCode = "I"
                processingStatusCode2.intervalBoundaryTypeCode = 1
                processingStatusCode2.lowerBoundaryProcessingStatusCode = 2
                val processingStatusCode3 = get<SelectionByProcessingStatusCode>()
                processingStatusCode3.incExclusionCode = "I"
                processingStatusCode3.intervalBoundaryTypeCode = 1
                processingStatusCode3.lowerBoundaryProcessingStatusCode = 3
                val processingStatusCodes = ArrayList<SelectionByProcessingStatusCode>()
                processingStatusCodes.add(processingStatusCode1)
                processingStatusCodes.add(processingStatusCode2)
                processingStatusCodes.add(processingStatusCode3)
                val processingConditions = get<ProcessingConditions>()
                processingConditions.maxQueryHits = 2
                processingConditions.unlimitedQueryHitsIndicator = false
                val taskSelectionByElements = get<TaskSelectionByElements>()
                taskSelectionByElements.processTypeCode = selectionByProcessTypeCode
                taskSelectionByElements.processingStatusCode = processingStatusCodes
                taskSelectionByElements.responsibleEmployeeIDs = responsibleEmployees
                Timber.e("task selection by elements: $taskSelectionByElements")
                val queryData = get<TasksByElementsQueryData>()
                queryData.taskSelectionByElements = taskSelectionByElements
                queryData.processingConditions = processingConditions
                Timber.e("query data: $queryData")
                val body = get<TasksByElementsQuery>()
                body.data = queryData
                Timber.e("body: $body")
                callTestSoapApi(body){
                    try {
                        Timber.e("data from response: ${it.body?.data?.tasks}")
                    } catch (e: Exception){
                        e.printStackTrace()
                    }
                }
            }*/
        }
    }
}