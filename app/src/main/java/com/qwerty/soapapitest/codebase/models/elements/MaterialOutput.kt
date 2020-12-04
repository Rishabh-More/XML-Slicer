package com.qwerty.soapapitest.codebase.models.elements

import org.simpleframework.xml.Root
import org.simpleframework.xml.Element
import org.simpleframework.xml.Attribute

@Root(name = "MaterialOutput")
class MaterialOutput {
    @Element(name = "SiteLogisticsLotMaterialOutputUUID")
    var lotMaterialOutputUniqueID: String? = null

    @Element(name = "TargetLogisticsAreaID")
    var targetAreaID: String? = null

    @Element(name = "ProductID")
    var productID: String? = null

    @Element(name = "ProductDescription")
    var productDescription: String? = null

    @Element(name = "PlanQuantity")
    @Attribute(name = "unitCode", required = false)
    var planQuantity: Double? = null

    @Element(name = "OpenQuantity")
    @Attribute(name = "unitCode", required = false)
    var openQuantity: Double? = null

    @Element(name = "TotalConfirmedQuantity")
    @Attribute(name = "unitCode", required = false)
    var totalConfirmedQuantity: Double? = null

    @Element(name = "LineItemID")
    var lineItemID: Int? = null

    @Element(name = "MaterialDeviationStatusCode")
    var deviationStatusCode: Int? = null
}