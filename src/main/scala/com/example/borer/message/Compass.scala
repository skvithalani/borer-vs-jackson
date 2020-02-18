package com.example.borer.message

import com.example.borer.model.Direction
import com.example.borer.serializable.BorerSerializable

final case class Compass(currentDirection: Direction) extends BorerSerializable
