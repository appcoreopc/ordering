package controllers

import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._


/**
  * Created by Jeremy on 3/12/2015.
  */
@RunWith(classOf[JUnitRunner])
class CartSpec extends Specification {

  "Cart spec main test" should {
    "hello world" in  {
      "hello word" must startWith("hello")
    }
  }
}
