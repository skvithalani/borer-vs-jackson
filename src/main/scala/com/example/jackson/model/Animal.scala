package com.example.jackson.model

import com.example.jackson.model.Animal.{Elephant, Lion}
import com.example.jackson.serializable.JsonSerializable
import com.fasterxml.jackson.annotation.{JsonSubTypes, JsonTypeInfo}

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes(
  Array(
    new JsonSubTypes.Type(value = classOf[Lion], name = "lion"),
    new JsonSubTypes.Type(value = classOf[Elephant], name = "elephant"),
  )
)
sealed abstract class Animal extends JsonSerializable

object Animal {

  final case class Lion(name: String) extends Animal {
    val kind = "mammal"
  }

  final case class Elephant(name: String, age: Int) extends Animal

  case object Tiger extends Animal {
    implicit val kind: String = "mammal"
  }
}
