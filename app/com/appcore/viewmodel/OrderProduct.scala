package com.appcore.viewmodel
import play.api.libs.json.Json

case class OrderProduct(id :Int, title : String, description : String, price : Double)

object OrderProduct {
  implicit val productReader = Json.writes[OrderProduct]
}
