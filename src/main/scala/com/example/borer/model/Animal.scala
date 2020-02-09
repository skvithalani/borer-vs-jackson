package com.example.borer.model

import com.example.borer.serializable.CborSerializable

sealed abstract class Animal extends CborSerializable

object Animal {
  final case class Lion(firstname: String) extends Animal {
    val kind = "mammal"
  }

  final case class Elephant(firstname: String, age: Int) extends Animal

  case object Tiger extends Animal {
    implicit val kind: String = "mammal"
  }
}
