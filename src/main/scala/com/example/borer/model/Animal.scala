package com.example.borer.model

import com.example.borer.serializable.CborSerializable

sealed abstract class Animal extends CborSerializable

object Animal {
  final case class Lion(name: String) extends Animal {
    val kind = "mammal"
  }

  final case class Elephant(name: String, age: Int) extends Animal

  case object Tiger extends Animal {
    implicit val kind: String = "mammal"
  }
}
