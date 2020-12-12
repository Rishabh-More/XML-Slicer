package com.qwerty.soapapitest.codebase.models.soapservice.elements

import org.simpleframework.xml.Root
import org.simpleframework.xml.Element
import org.simpleframework.xml.Attribute

@Root(name = "MaterialOutput")
data class MaterialOutput @JvmOverloads constructor (
    @field:Element(name = "SiteLogisticsLotMaterialOutputUUID", required = false)
    var lotMaterialOutputUniqueID: String? = null,

    @field:Element(name = "TargetLogisticsAreaID", required = false)
    var targetAreaID: String? = null,

    @field:Element(name = "ProductID", required = false)
    var productID: String? = null,

    @field:Element(name = "ProductDescription", required = false)
    var productDescription: String? = null,

    @field:Element(name = "PlanQuantity", required = false)
    @field:Attribute(name = "unitCode", required = false)
    var planQuantity: Double? = null,

    @field:Element(name = "OpenQuantity", required = false)
    @field:Attribute(name = "unitCode", required = false)
    var openQuantity: Double? = null,

    @field:Element(name = "TotalConfirmedQuantity", required = false)
    @field:Attribute(name = "unitCode", required = false)
    var totalConfirmedQuantity: Double? = null,

    @field:Element(name = "LineItemID", required = false)
    var lineItemID: Int? = null,

    @field:Element(name = "MaterialDeviationStatusCode", required = false)
    var deviationStatusCode: Int? = null
)