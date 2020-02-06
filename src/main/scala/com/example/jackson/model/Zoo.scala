package com.example.jackson.model

import com.example.jackson.serializable.JsonSerializable

final case class Zoo(primaryAttraction: Animal) extends JsonSerializable
