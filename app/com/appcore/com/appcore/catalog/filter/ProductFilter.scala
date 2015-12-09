package com.appcore.com.appcore.catalog.filter

import com.appcore.viewmodel.{OrderProduct}


object Filter {

  type ProductFilter = OrderProduct => Boolean

  def searchProduct(products : Set[OrderProduct], filter : ProductFilter) = products.filter(filter)

  // Defines filters //
  val searchByProductName : String => ProductFilter = keyword => product => product.name == keyword
  val searchByProductDescription : String => ProductFilter = keyword => product => product.description == keyword
  val searchByProductPrice : Double  => ProductFilter = keyword => product => product.price == keyword

  // defining multiple search criteria
  // predicate = means a function that return boolean
  // e.g

  // val a : String =>  Boolean = n => "test" == n
  // or  def aa(name : String) = { false }
  // here we are saying predicate takes anonymous function string that returns bool
  // val c = predicate[String](a) or predicate[String](a)("test")

  def predicate[A](predicate : A => Boolean) = (a:A) => predicate(a)
  def complement[A](predicate : A => Boolean) = (a:A) => !predicate(a)

  def any[A](predicate : (A => Boolean)*): A => Boolean =  a => predicate.exists(pred => pred(a))
  def none[A](predicate : (A =>Boolean)*): A => Boolean = complement(any(predicate: _*))
  def every[A](predicate : (A => Boolean)*) : A => Boolean = none(predicate.view.map(complement(_)): _*)
}

