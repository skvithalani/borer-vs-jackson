package com.example.borer.message

import com.example.borer.model.Animal
import com.example.borer.serializable.BorerSerializable

final case class Zoo(primaryAttraction: Animal) extends BorerSerializable
