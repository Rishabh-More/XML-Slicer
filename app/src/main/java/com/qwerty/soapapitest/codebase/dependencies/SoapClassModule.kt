package com.qwerty.soapapitest.codebase.dependencies

import com.qwerty.soapapitest.codebase.models.body.request.TasksByElementsQuery
import com.qwerty.soapapitest.codebase.models.data.TasksByElementsQueryData
import com.qwerty.soapapitest.codebase.models.elements.*
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