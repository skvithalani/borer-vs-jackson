package com.example.borer.cbor

import com.example.borer.model.{Animal, Compass, Direction, Zoo}
import com.example.borer.serializable.CborSerializable

class MyCborSerializer()
    extends CborCommonSerializer[CborSerializable]
    with Codecs {

  override def identifier: Int = 19923

  register[Direction]
  register[Compass]
  register[Animal]
  register[Zoo]
}
