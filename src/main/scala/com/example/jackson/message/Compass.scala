package com.example.jackson.message

import com.example.jackson.model.Direction
import com.example.jackson.serializable.JacksonSerializable

final case class Compass(currentDirection: Direction)
    extends JacksonSerializable
