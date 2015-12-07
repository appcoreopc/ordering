package com.appcore.viewmodel

import play.api.libs.json.Json


case class Product (id :String, name : String, description : String, price : Double)

object Product {

  implicit val productReader = Json.writes[Product]

}
