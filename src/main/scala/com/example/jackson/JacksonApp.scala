package com.example.jackson

import akka.actor.ActorSystem
import akka.serialization.{Serialization, SerializationExtension}
import com.example.jackson.message.{Compass, Zoo}
import com.example.jackson.model.Animal.{Lion, Tiger}
import com.example.jackson.model.Direction.North

import scala.concurrent.Await
import scala.concurrent.duration.DurationInt
import scala.util.Try

object JacksonApp extends App {
  private val system: ActorSystem          = ActorSystem("test")
  private val serialization: Serialization = SerializationExtension(system)

  private val lion             = Lion("lion")
  private val zoo: Zoo         = message.Zoo(lion)
  private val compass: Compass = Compass(North)

  println("-------------------- Serialized Data ----------------------------")

  println(new String(serialization.serialize(zoo).get, "utf-8"))
  println(new String(serialization.serialize(compass).get, "utf-8"))

  println("")
  println("-------------------- Deserialized Data ----------------------------")

  private val derializedZoo: Try[Zoo] =
    serialization.deserialize(serialization.serialize(zoo).get, classOf[Zoo])
  println(derializedZoo.get)

  println(serialization.deserialize(serialization.serialize(compass).get, classOf[Compass]).get)

  Await.result(system.terminate(), 5.seconds)
}
