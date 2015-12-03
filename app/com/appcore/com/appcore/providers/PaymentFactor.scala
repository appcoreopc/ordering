package com.appcore.com.appcore.providers

import com.appcore.com.appcore.providers.PaymentProviderType.PaymentProviderType

class PaymentFactory(paymentProvider : Payment with PaymentService)
{
    def getDefault() : Payment = {
      paymentProvider
  }

   def create(serviceType : PaymentProviderType) : Payment = {
     serviceType match {
       case PaymentProviderType.Master =>
         new Payment with MasterCardPaymentProvider
       case PaymentProviderType.Visa =>
         new Payment with VisaPaymentProvider
     }
   }
}
