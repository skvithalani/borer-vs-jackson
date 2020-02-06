package com.example.borer.cbor

import com.example.borer.model.{Animal, Zoo}
import com.example.borer.serializable.CborSerializable

class ZooSerializer()
    extends CborCommonSerializer[CborSerializable]
    with Codecs {

  override def identifier: Int = 19923

  register[Animal]
  register[Zoo]
}
