package com.appcore.com.appcore.providers

import com.appcore.viewmodel.CartProduct

class Payment()  {

  // or you can use self //
  this : PaymentService =>

  def Pay(cartProduct : CartProduct) : Some[Boolean] = {
    pay(cartProduct)
    return Some(true)
  }

}
