package com.appcore.actors

import akka.actor.Actor
import com.appcore.viewmodel.CartProduct

class PaymentActor extends Actor {

  override def receive: Receive = ???

  def Pay(cartProduct : CartProduct) : Some[Boolean] = {
    Some(true)
  }
}
