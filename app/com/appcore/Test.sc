
var r : Int => Int = a =>  a + 100
var p : Int => Int => Int = a => b => a + b
var q : Int => Int => Int => Int = a => b => c => a + b + c


def printAll(strings: String*) {
  println("------")
  strings.foreach(println)
}


var a : String => Int = a =>  100
var b : String => String => Int = a =>  a => 100
var c : String => String => Int = a =>  b =>  100
var d : String => Boolean => Int = a =>  b =>  100


def printAll(strings: String) {
  println("------")
  strings.foreach(println)
}
