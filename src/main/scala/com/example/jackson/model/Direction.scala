package com.example.jackson.model

import com.fasterxml.jackson.core.{JsonGenerator, JsonParser}
import com.fasterxml.jackson.databind.annotation.{JsonDeserialize, JsonSerialize}
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import com.fasterxml.jackson.databind.{DeserializationContext, SerializerProvider}

@JsonSerialize(using = classOf[DirectionJsonSerializer])
@JsonDeserialize(using = classOf[DirectionJsonDeserializer])
sealed trait Direction

object Direction {
  case object North extends Direction
  case object East  extends Direction
  case object South extends Direction
  case object West  extends Direction
}

class DirectionJsonSerializer extends StdSerializer[Direction](classOf[Direction]) {

  override def serialize(value: Direction, gen: JsonGenerator, provider: SerializerProvider): Unit = {
    val strValue = value match {
      case Direction.North => "North"
      case Direction.East  => "East"
      case Direction.South => "South"
      case Direction.West  => "West"
    }
    gen.writeString(strValue)
  }
}

class DirectionJsonDeserializer extends StdDeserializer[Direction](classOf[Direction]) {
  import Direction._

  override def deserialize(p: JsonParser, ctxt: DeserializationContext): Direction = {
    p.getText match {
      case "North" => North
      case "East"  => East
      case "South" => South
      case "West"  => West
    }
  }
}
