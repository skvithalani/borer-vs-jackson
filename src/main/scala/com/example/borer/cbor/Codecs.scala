package com.example.borer.cbor

import com.example.borer.model.{Animal, Compass, Direction, Zoo}
import io.bullet.borer.Codec
import io.bullet.borer.derivation.MapBasedCodecs
trait Codecs {
  implicit lazy val animalCodec: Codec[Animal] = MapBasedCodecs.deriveAllCodecs
  implicit lazy val zooCodec: Codec[Zoo] = MapBasedCodecs.deriveCodec
  implicit lazy val directionCodec: Codec[Direction] =
    MapBasedCodecs.deriveAllCodecs
  implicit lazy val compassCodec: Codec[Compass] = MapBasedCodecs.deriveCodec
}
