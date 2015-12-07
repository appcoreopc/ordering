package com.appcore.actors

import akka.actor.Actor
import com.appcore.com.appcore.providers.PaymentProviderType
import com.appcore.viewmodel.{PaymentCartProduct, PaymentComplete, CartProduct}

class PaymentActor extends Actor {

  def receive = {

    case PaymentCartProduct => {
      println("Initiate payment")
      sender ! PaymentComplete("1234", PaymentProviderType.Master, "1234")
    }
  }
}
