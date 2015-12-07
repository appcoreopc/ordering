package com.appcore.viewmodel

import com.appcore.com.appcore.providers.PaymentProviderType.PaymentProviderType

case class PaymentCartProduct (transactionId : String, providerType : PaymentProviderType, cartProduct : CartProduct)

