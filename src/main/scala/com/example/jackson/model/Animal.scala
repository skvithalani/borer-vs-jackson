package com.example.jackson.model

import com.example.jackson.model.Animal.{Elephant, Lion, Tiger}
import com.example.jackson.serializable.JacksonSerializable
import com.fasterxml.jackson.annotation.{JsonSubTypes, JsonTypeInfo}

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes(
  Array(
    new JsonSubTypes.Type(value = classOf[Lion], name = "lion"),
    new JsonSubTypes.Type(value = classOf[Elephant], name = "elephant"),
    new JsonSubTypes.Type(value = classOf[Tiger], name = "tiger"),
  )
)
sealed abstract class Animal extends JacksonSerializable

object Animal {

  final case class Lion(firstname: String) extends Animal {
    val kind = "mammal"
  }

  final case class Elephant(firstname: String, age: Int) extends Animal

  case class Tiger() extends Animal {
    implicit val kind: String = "mammal"
  }
}
