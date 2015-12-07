package com.appcore.actors

import akka.actor.{Props, ActorSystem, ActorRef}
import com.appcore.viewmodel.{PaymentCartProduct, CartProduct}

class OrderingEnv {

  val actorSystem = ActorSystem("OrderingActor")
  val cartActor = actorSystem.actorOf(Props[CartActor], "CartActor")
  val paymentActor = actorSystem.actorOf(Props[PaymentActor], "PaymentActor")

  def pay(cartProduct : PaymentCartProduct) = {
    paymentActor ! cartProduct
  }
}
