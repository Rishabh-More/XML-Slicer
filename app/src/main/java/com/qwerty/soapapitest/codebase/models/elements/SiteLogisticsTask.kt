package com.qwerty.soapapitest.codebase.models.elements

import org.simpleframework.xml.Root
import org.simpleframework.xml.Element
import org.simpleframework.xml.Attribute

@Root(name = "SiteLogisticsTask")
data class SiteLogisticsTask @JvmOverloads constructor (
    @field:Element(name = "SiteLogisticsTaskID", required = false)
    var taskID: Int? = null,

    @field:Element(name = "SiteLogisticsTaskUUID", required = false)
    var taskUniqueID: String? = null,

    @field:Element(name = "OperationTypeCode", required = false)
    @field:Attribute(name = "listAgencyID")
    var operationTypeCode: Int? = null,

    @field:Element(name = "BusinessTransactionDocumentReferenceID", required = false)
    var transactionDocumentRefID: Int? = null,

    @field:Element(name = "SiteLogisticsTaskReferencedObject", required = false)
    var taskData: TaskReferencedObject? = null,

    @field:Element(name = "CustomerParty", required = false)
    var customerDetails: CustomerParty? = null,

    @field:Element(name = "EarliestExecutionStartDate", required = false)
    var earliestStartDate: String? = null,

    @field:Element(name = "LatestExecutionEndDate", required = false)
    var latestEndDate: String? = null
)