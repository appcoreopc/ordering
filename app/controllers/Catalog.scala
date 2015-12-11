package controllers

import com.appcore.com.appcore.com.appcore.data.{ProductRepository}
import com.appcore.viewmodel.OrderProduct
import play.api.libs.json.Json
import play.api.mvc._

class Catalog extends Controller {

  def index = Action { implicit request =>
    //val blah = Json.parse(request.body.asText.get).as[UserResponse]
    Ok("catalog")
    // to return Blah as application/json, you just have to convert your Blah to a JsValue and give it to Ok()
    //Ok(Json.toJson(blah))
  }

  def getAll() = Action {

    val catalog = new Catalog with ProductRepository
    val result = catalog.getProducts()
    Ok(Json.arr(result))
  }

  def getProduct(productId : String) = Action {
    val p = new OrderProduct(1, "Demo", "Demo App", 12.0)
    Ok(Json.toJson(p))
  }
}
