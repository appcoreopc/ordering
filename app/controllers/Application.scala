package controllers
import anorm._
import play.api._
import play.api.mvc._
import play.api.db.DB
import play.api.Play.current

class Application extends Controller {

  def index = Action {
    // try query database //
    DB.withConnection { implicit c =>
      val result: Boolean = SQL("Select 1").execute()

      if (result)
         {
           Ok("ok we have results ")
         }
      else
        Ok("opsss...query not succesful ")
    }


    Ok(views.html.index("Your new application is ready."))
  }

}
