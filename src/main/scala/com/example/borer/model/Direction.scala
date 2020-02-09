package com.example.borer.model

import com.example.borer.serializable.BorerSerializable

sealed trait Direction extends BorerSerializable

object Direction {
  case object North extends Direction
  case object East extends Direction
  case object South extends Direction
  case object West extends Direction
}

final case class Compass(currentDirection: Direction) extends BorerSerializable
