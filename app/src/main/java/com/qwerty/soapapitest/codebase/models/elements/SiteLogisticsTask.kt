package com.qwerty.soapapitest.codebase.models.elements

import com.tickaroo.tikxml.annotation.*

//import org.simpleframework.xml.Root
//import org.simpleframework.xml.Element
//import org.simpleframework.xml.Attribute

//@Root(name = "SiteLogisticsTask")
@Xml(name = "SiteLogisticsTask")
class SiteLogisticsTask {
    @PropertyElement(name = "SiteLogisticsTaskID")
    var taskID: Int? = null

    @PropertyElement(name = "SiteLogisticsTaskUUID")
    var taskUniqueID: String? = null

    @PropertyElement(name = "OperationTypeCode")
    var operationTypeCode: OperationTypeCode? = null

    @PropertyElement(name = "BusinessTransactionDocumentReferenceID")
    var transactionDocumentRefID: Int? = null

    @Element(name = "SiteLogisticsTaskReferencedObject")
    var taskData: TaskReferencedObject? = null

    @Element(name = "CustomerParty")
    var customerDetails: CustomerParty? = null

    @PropertyElement(name = "EarliestExecutionStartDate")
    var earliestStartDate: String? = null

    @PropertyElement(name = "LatestExecutionEndDate")
    var latestEndDate: String? = null
}