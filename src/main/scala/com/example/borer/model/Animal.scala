package com.example.borer.model

sealed abstract class Animal

object Animal {
  final case class Lion(name: String)               extends Animal
  final case class Elephant(name: String, age: Int) extends Animal
  final case object Tiger                           extends Animal
}
