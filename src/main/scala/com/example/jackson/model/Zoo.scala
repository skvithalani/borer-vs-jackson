package com.example.jackson.model

import com.example.jackson.serializable.JacksonSerializable

final case class Zoo(primaryAttraction: Animal) extends JacksonSerializable
