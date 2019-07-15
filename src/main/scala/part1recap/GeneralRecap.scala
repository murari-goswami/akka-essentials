package part1recap

import scala.util.Try

object GeneralRecap extends App {

  val aCondition: Boolean = false

  var aVariable = 42
  aVariable += 1 // 43

  // expressions
  val aConditionedVal = if (aCondition) 42 else 65

  // code block
  val aCodeBlock = {
    if (aCondition) 4
    56
  }

  // types
  // Unit
  val theUnit = println("something")

  // function
  def aFunction(x: Int, y: Int) = x + y

  //recursion - Tail recursion
  def factorial(num: Int, accum: Int): Int = { // recursion needs an explicit return type
    if (num <= 0) accum
    else factorial(num - 1, accum * num)
  }

  // OOP
  class Animal

  class Dog extends Animal

  val aDog: Animal = new Dog

  trait Carnivore {
    def eat(a: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override def eat(a: Animal): Unit = println("crunch")
  }

  // method notation
  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog

  // anonymous classes
  val aCarnivore = new Carnivore {
    override def eat(a: Animal): Unit = println("roar")
  }

  aCarnivore eat aDog

  // generics
  abstract class myList[+A] // + means an extension
  // companion object
  object myList

  // case classes
  case class Person(name: String, age: Int)

  // Exception
  val aPotentialFailure = try {
    throw new RuntimeException("I am innocent, I swear") // returns nothing
  } catch {
    case e: Exception => "I caught an exception"
  } finally {
    // side affects
    println("some logs")
  }

  // Functional programming
  val incrementer = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 + 1
  }

  val incremented = incrementer(42) // object will call the apply method and increment the value

  val anonymousIncrementer = (x: Int) => x + 1
  // Int => Int === Function[Int, Int]

  List(1, 2, 3).map(incrementer)
  // map - HOF

  // for comprehension
  val Pairs = for {
    num <- List(1, 2, 3, 4)
    char <- List('a', 'b', 'c', 'd')
  } yield num + "-" + char

  // same as
  // List(1,2,3,4).flatMap(num => List('a', 'b', 'c', 'd').map(char => num + "-" + char))

  // Seq, Array, List, Vector, Map, Tuples, Sets

  // "collections"
  // Option and try
  val anOption = Some(2)
  val aTry = Try {
    throw new RuntimeException
  }

  // pattern matching
  val unknown = 2
  val order = unknown match {
    case 1 => "first"
    case 2 => "second"
    case _ => "unknown"
  }

  val bob = Person("Bob", 22)
  val greeting = bob match {
    case Person(n, _) => s"Hi, may name is $n"
    case _ => "I dont know the name"
  }

}
