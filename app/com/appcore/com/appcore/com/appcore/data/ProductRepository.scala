package com.appcore.com.appcore.com.appcore.data

import anorm._
import com.appcore.viewmodel.OrderProduct
import play.api.db.DB
import play.api.Play.current

//case class OrderProduct(id :Int, title : String, description : String, price : Double)

trait ProductRepository extends ProductCatalogService {

  def getProducts(): List[OrderProduct] = {

    DB.withConnection { implicit c =>
      val productQuery = SQL("SELECT * FROM PRODUCT")
      return productQuery().map(
        prod => new OrderProduct(prod[Int]("ID"), prod[String]("NAME"),
          prod[String]("DESCRIPTION"), prod[Int]("PRICE"))
      ).toList
    }
  }

  def getProducts(filter : OrderProduct => Boolean): List[OrderProduct] = {

    DB.withConnection { implicit c =>
      val productQuery = SQL("SELECT * FROM PRODUCT")
      return productQuery().map(
        prod => new OrderProduct(prod[Int]("ID"), prod[String]("NAME"),
          prod[String]("DESCRIPTION"), prod[Int]("PRICE"))
      ).toList.filter(filter)
    }
  }
}

trait ProductCatalogService
{
  def getProducts(): List[OrderProduct]
  def getProducts(filter : OrderProduct => Boolean): List[OrderProduct]
}

class Catalog {

  this : ProductCatalogService =>

  def getProducts(): List[OrderProduct] = {
     return this.getProducts()
  }

  def getProducts(filter : OrderProduct => Boolean): List[OrderProduct] = {
  return this.getProducts(filter)
  }
}