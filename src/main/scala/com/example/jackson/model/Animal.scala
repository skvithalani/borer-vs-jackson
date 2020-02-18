package com.example.jackson.model

import com.example.jackson.model.Animal.{Elephant, Lion}
import com.fasterxml.jackson.annotation.{JsonSubTypes, JsonTypeInfo}

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes(
  Array(
    new JsonSubTypes.Type(value = classOf[Lion], name = "lion"),
    new JsonSubTypes.Type(value = classOf[Elephant], name = "elephant")
  )
)
sealed abstract class Animal

object Animal {
  final case class Lion(name: String)               extends Animal
  final case class Elephant(name: String, age: Int) extends Animal
  final case object Tiger                           extends Animal
}
