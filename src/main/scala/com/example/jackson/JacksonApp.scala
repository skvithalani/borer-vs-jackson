package com.example.jackson

import akka.actor.ActorSystem
import akka.serialization.{Serialization, SerializationExtension}
import com.example.jackson.model.Animal.{Lion, Tiger}
import com.example.jackson.model.Direction.North
import com.example.jackson.model.{Compass, Direction, Zoo}

import scala.concurrent.Await
import scala.concurrent.duration.DurationInt
import scala.util.Try

object JacksonApp extends App {
  private val system: ActorSystem = ActorSystem("test")
  private val serialization: Serialization = SerializationExtension(system)
  private val lion = Lion("lion")
  private val zoo: Zoo = Zoo(lion)

  println("-------------------- Serialized Data ----------------------------")

  println(new String(serialization.serialize(zoo).get, "utf-8"))
  println(new String(serialization.serialize(lion).get, "utf-8"))
  println(new String(serialization.serialize(Zoo(Tiger())).get, "utf-8"))
  println(new String(serialization.serialize(Tiger()).get, "utf-8"))
  private val north = serialization.serialize(North).get
  private val compass: Array[Byte] = serialization.serialize(Compass(North)).get
  println(new String(compass, "utf-8"))
  println(new String(north))

  println("")
  println("-------------------- Deserialized Data ----------------------------")

  private val derializedZoo: Try[Zoo] =
    serialization.deserialize(serialization.serialize(zoo).get, classOf[Zoo])
  println(derializedZoo.get)

  private val deserializedTiger: Try[Zoo] =
    serialization.deserialize(
      serialization.serialize(Zoo(Tiger())).get,
      classOf[Zoo]
    )
  println(deserializedTiger.get)
  println(serialization.deserialize(north, classOf[Direction]).get)
  println(serialization.deserialize(compass, classOf[Compass]).get)

  Await.result(system.terminate(), 5.seconds)
}
