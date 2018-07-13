package org.minyodev.simple

import parquet.org.apache.thrift.TException
import tutorial.MultiplicationService

class MultiplicationHandler extends MultiplicationService.Iface {

  @throws[TException]
  override def multiply(n1: Int, n2: Int): Int =  {
    println("Multiply(" + n1 + "," + n2 + ")");
    n1 * n2
  }
}
