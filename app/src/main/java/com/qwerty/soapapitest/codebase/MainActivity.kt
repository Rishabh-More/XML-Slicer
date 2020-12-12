package com.qwerty.soapapitest.codebase

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.qwerty.soapapitest.base.BaseActivity
import com.qwerty.soapapitest.codebase.models.middleware.Login
import com.qwerty.soapapitest.codebase.models.soapservice.body.request.TasksByElementsQuery
import com.qwerty.soapapitest.codebase.models.soapservice.data.TasksByElementsQueryData
import com.qwerty.soapapitest.codebase.models.soapservice.elements.*
import com.qwerty.soapapitest.codebase.network.callDemoLogin
import com.qwerty.soapapitest.codebase.network.callTestSoapApi
import com.qwerty.soapapitest.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get
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
            lifecycleScope.launch(Dispatchers.Main){
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
            }
        }
    }
}