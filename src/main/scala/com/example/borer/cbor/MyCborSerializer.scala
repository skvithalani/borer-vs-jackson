package com.example.borer.cbor

import com.example.borer.model.{Animal, Compass, Direction, Zoo}
import com.example.borer.serializable.BorerSerializable

class MyCborSerializer()
    extends CborCommonSerializer[BorerSerializable]
    with Codecs {

  override def identifier: Int = 19923

  register[Direction]
  register[Compass]
  register[Animal]
  register[Zoo]
}
