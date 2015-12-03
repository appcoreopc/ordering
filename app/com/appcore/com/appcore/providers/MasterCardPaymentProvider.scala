package com.appcore.com.appcore.providers

import com.appcore.com.appcore.providers.PaymentProviderType.PaymentProviderType
import com.appcore.viewmodel.CartProduct

/**
  * Created by jeremyw on 03/12/2015.
  */
trait MasterCardPaymentProvider extends PaymentService {

  override def name: Some[String] = Some("MasterCard")

  override def pay(cartProduct: CartProduct): Some[Boolean] = {
    println("paying with master card")
    Some(true)
  }

  override def providerType: PaymentProviderType = PaymentProviderType.Master
}
