package com.example.borer

import akka.actor.ActorSystem
import akka.serialization.{Serialization, SerializationExtension}
import com.example.borer.message.{Compass, Zoo}
import com.example.borer.model.Animal.{Lion, Tiger}
import com.example.borer.model.Direction.North

import scala.concurrent.Await
import scala.concurrent.duration.DurationInt

object BorerApp extends App {
  private val system: ActorSystem          = ActorSystem("test")
  private val serialization: Serialization = SerializationExtension(system)

  private val zoo: Zoo         = message.Zoo(Lion("lion"))
  private val compass: Compass = Compass(North)

  println("-------------------- Serialized Data ----------------------------")
  println(new String(serialization.serialize(zoo).get, "utf-8"))
  println(new String(serialization.serialize(Zoo(Tiger)).get, "utf-8"))
  println(new String(serialization.serialize(compass).get, "utf-8"))

  println("")
  println("-------------------- Deserialized Data ----------------------------")

  println(serialization.deserialize(serialization.serialize(zoo).get, classOf[Zoo]).get)
  println(serialization.deserialize(serialization.serialize(Zoo(Tiger)).get, classOf[Zoo]).get)
  println(serialization.deserialize(serialization.serialize(compass).get, classOf[Compass]).get)

  Await.result(system.terminate(), 5.seconds)
}
