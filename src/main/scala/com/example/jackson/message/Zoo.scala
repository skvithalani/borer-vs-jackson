package com.example.jackson.message

import com.example.jackson.model.Animal
import com.example.jackson.serializable.JacksonSerializable

final case class Zoo(primaryAttraction: Animal) extends JacksonSerializable
