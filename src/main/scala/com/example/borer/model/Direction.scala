package com.example.borer.model

import com.example.borer.serializable.CborSerializable

sealed trait Direction extends CborSerializable

object Direction {
  case object North extends Direction
  case object East extends Direction
  case object South extends Direction
  case object West extends Direction
}

final case class Compass(currentDirection: Direction) extends CborSerializable
