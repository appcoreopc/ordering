package com.appcore.viewmodel

import play.api.libs.functional.syntax._
import play.api.libs.json.{JsPath, Json, Reads}

case class CartProduct(id : Int, productId : Int,  qty : Double)

object CartProduct {

  implicit val cartProductWrites  = Json.writes[CartProduct]

  implicit val cartProductReads: Reads[CartProduct] = (
    (JsPath \ "id").read[Int] and
      (JsPath \ "productId").read[Int] and
      (JsPath \ "qty").read[Double]
    )(CartProduct.apply _)
}
