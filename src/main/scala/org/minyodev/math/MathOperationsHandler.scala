package org.minyodev.math

import org.apache.thrift.TException
import services.MathOperations

class MathOperationsHandler extends MathOperations.Iface {

  @throws[TException]
  override def add(a: Int, b: Int): Int = {
    println(s"add: ${a} + ${b}")
    a + b
  }

  @throws[TException]
  override def multiply(a: Int, b: Int): Int = {
    a * b
  }

  @throws[TException]
  override def sub(a: Int, b: Int): Int = {
    a - b
  }

}
