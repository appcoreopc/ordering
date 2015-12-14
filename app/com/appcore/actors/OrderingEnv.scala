package com.appcore.actors

import akka.actor.{ActorSystem, Props}
import com.appcore.viewmodel.PaymentCartProduct

class OrderingEnv {

  val actorSystem = ActorSystem("OrderingActor")
  val cartActor = actorSystem.actorOf(Props[CartActor], "CartActor")
  val paymentActor = actorSystem.actorOf(Props[PaymentActor], "PaymentActor")

  def pay(cartProduct : PaymentCartProduct) = {
    paymentActor ! cartProduct
  }

}
