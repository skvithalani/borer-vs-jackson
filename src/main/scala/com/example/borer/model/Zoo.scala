package com.example.borer.model

import com.example.borer.serializable.CborSerializable

final case class Zoo(primaryAttraction: Animal) extends CborSerializable
