package com.appcore.actors

import akka.actor.Actor
import com.appcore.viewmodel.PaymentComplete

class CartActor extends Actor {

  def receive =  {
    case PaymentComplete => println("payment complete")
  }
}
