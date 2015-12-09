package com.appcore.com.appcore.providers

import com.appcore.com.appcore.providers.PaymentProviderType.PaymentProviderType
import com.appcore.viewmodel.CartProduct

trait VisaPaymentProvider extends PaymentService {

  override def name: Some[String] = ???

  override def providerType: PaymentProviderType = ???

  override def pay(cartProduct: CartProduct): Some[Boolean] = {
    println("Pay with visa card")
    Some(true)
  }
}
