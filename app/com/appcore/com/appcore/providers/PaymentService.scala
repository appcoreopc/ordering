package com.appcore.com.appcore.providers

import com.appcore.com.appcore.providers.PaymentProviderType.PaymentProviderType
import com.appcore.viewmodel.CartProduct

trait PaymentService
{
  def name : Some[String]
  def providerType : PaymentProviderType
  def pay(cartProduct : CartProduct) : Some[Boolean]
}
