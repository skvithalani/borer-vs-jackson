package com.example.borer

import akka.actor.ActorSystem
import akka.serialization.{Serialization, SerializationExtension}
import com.example.borer.model.Animal.{Lion, Tiger}
import com.example.borer.model.Zoo

import scala.concurrent.Await
import scala.concurrent.duration.DurationInt

object BorerApp extends App {
  private val system: ActorSystem = ActorSystem("test")
  private val serialization: Serialization = SerializationExtension(system)

  private val lion = Lion("lion")
  private val zoo: Zoo = Zoo(lion)
  println(new String(serialization.serialize(zoo).get, "utf-8"))
  println(new String(serialization.serialize(lion).get, "utf-8"))
  println(new String(serialization.serialize(Zoo(Tiger)).get, "utf-8"))
  println(new String(serialization.serialize(Tiger).get, "utf-8"))

  Await.result(system.terminate(), 5.seconds)
}
