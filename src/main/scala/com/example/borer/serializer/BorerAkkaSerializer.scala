package com.example.borer.serializer

import akka.actor.ExtendedActorSystem
import akka.serialization.Serializer
import com.example.borer.codec.Codecs
import com.example.borer.message.{Compass, Zoo}
import io.bullet.borer.{Decoder, Json}

import scala.reflect.ClassTag

class BorerAkkaSerializer(_actorSystem: ExtendedActorSystem) extends Serializer with Codecs {

  override def identifier: Int          = 19923
  override def includeManifest: Boolean = true

  override def toBinary(o: AnyRef): Array[Byte] = o match {
    case x: Zoo     => Json.encode(x).toByteArray
    case x: Compass => Json.encode(x).toByteArray
    case _ =>
      throw new RuntimeException(s"does not support encoding of $o")
  }

  override def fromBinary(bytes: Array[Byte], manifest: Option[Class[_]]): AnyRef = {
    def fromBinary[T: ClassTag: Decoder]: Option[T] = {
      val clazz = scala.reflect.classTag[T].runtimeClass
      if (clazz.isAssignableFrom(manifest.get))
        Some(Json.decode(bytes).to[T].value)
      else None
    }

    {
      fromBinary[Zoo] orElse
      fromBinary[Compass]
    }.getOrElse {
      throw new RuntimeException(
        s"does not support decoding of ${manifest.get}"
      )
    }
  }
}
