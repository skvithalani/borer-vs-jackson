package com.example.borer.cbor

import com.example.borer.model.{Animal, Zoo}
import io.bullet.borer.Codec
import io.bullet.borer.derivation.MapBasedCodecs

trait Codecs {
  implicit lazy val animalCodec: Codec[Animal] = MapBasedCodecs.deriveAllCodecs
  implicit lazy val zooCodec: Codec[Zoo] = MapBasedCodecs.deriveCodec
}
