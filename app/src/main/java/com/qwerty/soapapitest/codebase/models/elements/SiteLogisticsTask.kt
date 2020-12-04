package com.qwerty.soapapitest.codebase.models.elements

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Xml

//import org.simpleframework.xml.Root
//import org.simpleframework.xml.Element
//import org.simpleframework.xml.Attribute

//@Root(name = "SiteLogisticsTask")
@Xml(name = "SiteLogisticsTask")
class SiteLogisticsTask {
    @Element(name = "SiteLogisticsTaskID")
    var taskID: Int? = null

    @Element(name = "SiteLogisticsTaskUUID")
    var taskUniqueID: String? = null

    @Element(name = "OperationTypeCode")
    //@Attribute(name = "listAgencyID")
    var operationTypeCode: Int? = null

    @Element(name = "BusinessTransactionDocumentReferenceID")
    var transactionDocumentRefID: Int? = null

    @Element(name = "SiteLogisticsTaskReferencedObject")
    var taskData: TaskReferencedObject? = null

    @Element(name = "CustomerParty")
    var customerDetails: CustomerParty? = null

    @Element(name = "EarliestExecutionStartDate")
    var earliestStartDate: String? = null

    @Element(name = "LatestExecutionEndDate")
    var latestEndDate: String? = null
}