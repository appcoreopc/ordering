package controllers
import com.appcore.com.appcore.com.appcore.data.CartRepository
import com.appcore.viewmodel.CartProduct
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    val cart = new CartRepository
    cart.createCart(new CartProduct(24, 1, 10))
    Ok(views.html.index("Your new application is ready.")).withSession("userId" -> "test@gmail.com")
  }
}
