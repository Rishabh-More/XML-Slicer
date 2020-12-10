package com.qwerty.soapapitest.codebase.models.elements

import com.tickaroo.tikxml.annotation.*

//import org.simpleframework.xml.Root
//import org.simpleframework.xml.Element
//import org.simpleframework.xml.Attribute

//@Root(name = "MaterialOutput")
@Xml(name = "MaterialOutput")
class MaterialOutput {
    @PropertyElement(name = "SiteLogisticsLotMaterialOutputUUID")
    var lotMaterialOutputUniqueID: String? = null

    @PropertyElement(name = "TargetLogisticsAreaID")
    var targetAreaID: String? = null

    @PropertyElement(name = "ProductID")
    var productID: String? = null

    @PropertyElement(name = "ProductDescription")
    var productDescription: String? = null

    @Element(name = "PlanQuantity")
    var planQuantity: PlanQuantity? = null

    @Element(name = "OpenQuantity")
    var openQuantity: OpenQuantity? = null

    @Element(name = "TotalConfirmedQuantity")
    var totalConfirmedQuantity: TotalConfirmedQuantity? = null

    @PropertyElement(name = "LineItemID")
    var lineItemID: Int? = null

    @PropertyElement(name = "MaterialDeviationStatusCode")
    var deviationStatusCode: Int? = null
}