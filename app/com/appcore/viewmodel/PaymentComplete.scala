package com.appcore.viewmodel

import com.appcore.com.appcore.providers.PaymentProviderType.PaymentProviderType

case class PaymentComplete (transactionId : String, providerType : PaymentProviderType, cartId : String)

