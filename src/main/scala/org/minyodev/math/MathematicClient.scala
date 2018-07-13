package org.minyodev.math

import org.apache.thrift.TException
import org.apache.thrift.protocol.{TBinaryProtocol, TProtocol}
import org.apache.thrift.transport.{TSocket, TTransport, TTransportException}
import services.MathOperations

object MathematicClient {

  def add(a: Int, b: Int): Int = {
    var transport: TTransport = null
    try {
      transport = new TSocket("localhost", 9090)
      val protocol: TProtocol = new TBinaryProtocol(transport)

      val client: MathOperations.Client = new MathOperations.Client(protocol)
      transport.open()

      val addResult = client.add(a, b)
      addResult
    }
    catch {
      case e: TTransportException => e.printStackTrace()
        0
      case e: TException => e.printStackTrace()
        0
    }
    finally {
      transport.close
    }
  }

  def main(args: Array[String]): Unit = {
    println("Calling add()...")
    println("Add: " + add(9, 9))
    println("Called!...")
  }
}
