package com.qwerty.soapapitest.codebase.dependencies

import com.qwerty.soapapitest.codebase.models.soapservice.body.request.TasksByElementsQuery
import com.qwerty.soapapitest.codebase.models.soapservice.data.TasksByElementsQueryData
import com.qwerty.soapapitest.codebase.models.soapservice.elements.*
import org.koin.dsl.module

val soapClassModule = module {
    factory { TasksByElementsQuery() }
    factory { TasksByElementsQueryData() }
    factory { TaskSelectionByElements() }
    factory { ProcessingConditions() }
    factory { SelectionByProcessTypeCode() }
    factory { SelectionByResponsibleEmployeeID() }
    factory { SelectionByProcessingStatusCode() }
}