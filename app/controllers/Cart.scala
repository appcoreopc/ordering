package controllers

import com.appcore.viewmodel.CartProduct
import play.api.mvc._

class Cart extends Controller {

  def index = Action { request =>
    val cart = request.session.get("cart").getOrElse(None)
    if (cart != None) {
      // get cart product info //
    }
    Ok("ok")
  }

  def add = Action(BodyParsers.parse.json) {
    request => val cartProduct = request.body.validate[CartProduct]
      val cartProductInstance = cartProduct.asOpt
      val item = (cartProductInstance match {
        case Some(value) => value
        case _ => None
      })

      if (item != None) {
        Ok("Product item added").withSession("cart" -> "true")
      }
      else {
        Ok("ok but no cart data added!")
      }
  }
}


