package com.appcore.actors

import akka.actor.Actor
import com.appcore.com.appcore.providers.PaymentProviderType
import com.appcore.viewmodel.{PaymentCartProduct, PaymentComplete}

class PaymentActor extends Actor {

  def receive = {
    case cartProduct : PaymentCartProduct => {
      println("Initiate payment")
      sender ! PaymentComplete("1234", PaymentProviderType.Master, "1234")
    }
    case _ => {
      println("hmmmmmm.....")
    }
  }
}
