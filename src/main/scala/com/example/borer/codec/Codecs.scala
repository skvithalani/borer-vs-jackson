package com.example.borer.codec

import com.example.borer.message.{Compass, Zoo}
import com.example.borer.model.{Animal, Direction}
import io.bullet.borer.Codec
import io.bullet.borer.derivation.MapBasedCodecs.{deriveAllCodecs, deriveCodec}

trait Codecs {
  implicit lazy val animalCodec: Codec[Animal]       = deriveAllCodecs
  implicit lazy val zooCodec: Codec[Zoo]             = deriveCodec
  implicit lazy val directionCodec: Codec[Direction] = deriveAllCodecs
  implicit lazy val compassCodec: Codec[Compass]     = deriveCodec
}
