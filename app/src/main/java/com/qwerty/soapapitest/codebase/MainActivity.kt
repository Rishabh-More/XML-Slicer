package com.qwerty.soapapitest.codebase

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.qwerty.soapapitest.base.BaseActivity
import com.qwerty.soapapitest.codebase.models.body.request.TasksByElementsQuery
import com.qwerty.soapapitest.codebase.models.elements.ProcessingConditions
import com.qwerty.soapapitest.codebase.models.elements.SelectionByProcessTypeCode
import com.qwerty.soapapitest.codebase.models.elements.SelectionByProcessingStatusCode
import com.qwerty.soapapitest.codebase.models.elements.SelectionByResponsibleEmployeeID
import com.qwerty.soapapitest.codebase.network.callTestSoapApi
import com.qwerty.soapapitest.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Timber.tag("MAIN_ACTIVITY")

        binding.mainActionButton.setOnClickListener {
            Timber.e("Button Clicked")
            lifecycleScope.launch(Dispatchers.IO){
                val selectionByProcessTypeCode = SelectionByProcessTypeCode()
                selectionByProcessTypeCode.incExclusionCode = "I"
                selectionByProcessTypeCode.intervalBoundaryTypeCode = 1
                selectionByProcessTypeCode.lowerBoundaryTypeCode = 1
                val employee1 = SelectionByResponsibleEmployeeID()
                employee1.incExclusionCode = "I"
                employee1.intervalBoundaryTypeCode = 1
                employee1.lowerBoundaryEmployeeID = "E0005"
                val employee2 = SelectionByResponsibleEmployeeID()
                employee2.incExclusionCode = "E"
                employee2.intervalBoundaryTypeCode = 1
                employee2.lowerBoundaryEmployeeID = "\"*\""
                val responsibleEmployees = ArrayList<SelectionByResponsibleEmployeeID>()
                responsibleEmployees.add(employee1)
                responsibleEmployees.add(employee2)
                val processingStatusCode1 = SelectionByProcessingStatusCode()
                processingStatusCode1.incExclusionCode = "I"
                processingStatusCode1.intervalBoundaryTypeCode = 1
                processingStatusCode1.lowerBoundaryProcessingStatusCode = 1
                val processingStatusCode2 = SelectionByProcessingStatusCode()
                processingStatusCode2.incExclusionCode = "I"
                processingStatusCode2.intervalBoundaryTypeCode = 1
                processingStatusCode2.lowerBoundaryProcessingStatusCode = 2
                val processingStatusCode3 = SelectionByProcessingStatusCode()
                processingStatusCode3.incExclusionCode = "I"
                processingStatusCode3.intervalBoundaryTypeCode = 1
                processingStatusCode3.lowerBoundaryProcessingStatusCode = 3
                val processingStatusCodes = ArrayList<SelectionByProcessingStatusCode>()
                processingStatusCodes.add(processingStatusCode1)
                processingStatusCodes.add(processingStatusCode2)
                processingStatusCodes.add(processingStatusCode3)
                val processingConditions = ProcessingConditions()
                processingConditions.maxQueryHits = 2
                processingConditions.unlimitedQueryHitsIndicator = false
                val data = TasksByElementsQuery()
                data.data?.processingConditions = processingConditions
                data.data?.taskSelectionByElements?.processTypeCode = selectionByProcessTypeCode
                data.data?.taskSelectionByElements?.processingStatusCode = processingStatusCodes
                data.data?.taskSelectionByElements?.responsibleEmployeeIDs = responsibleEmployees
                callTestSoapApi(data){
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