package com.appcore.com.appcore.com.appcore.data

import anorm._
import com.appcore.viewmodel.{CartProductState, CartProduct}
import play.api.db.DB
import play.api.Play.current

trait CartRepositoryService {
  def getCart(id: Int): Option[CartProduct]

  def createCart(cartProduct: CartProduct): Option[CartProductState]
}

class CartRepository {

  def getCart(id: Int): Option[CartProduct] = {
    DB.withConnection { implicit c =>
      val cartQuery = SQL("SELECT * FROM PRODUCT WHERE id={id}")
      return cartQuery().filter(a => a != null).headOption.map(row =>
        new CartProduct(row[Int]("ID"), row[Int]("productId"), row[Int]("qty"))
      ).headOption
    }
  }

  def createCart(cartProduct: CartProduct): Option[CartProductState] = {
    try {
      DB.withConnection { implicit c =>
        val str = "INSERT INTO CART( id, description, productid) values ({id}, {description}, {productid})"
        val createCartResult = SQL(str).on("id" -> cartProduct.id, "productid" -> cartProduct.productId, "description" -> "apps").execute()
        if (createCartResult) {
          println("we are good")
        }
        else {
          println("Crap!")
        }
      }
    }
    catch {
      case _ => println("ops! unable to create cart")
    }
    None
  }

  def updateCart(cartProduct: CartProduct): Option[CartProductState] = {
    DB.withConnection { implicit c =>
      val createCartQuery = SQL("INSERT INTO CART( id, description, productid) values ({cartProduct.id}, {cartProduct.description}, {cartProduct.productId})").executeQuery()
      val result = new CartProductState(cartProduct.id, cartProduct.productId, cartProduct.qty, true)
      return Some(result)
    }
    None
  }
}
