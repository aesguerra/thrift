package org.minyodev.simple

import org.apache.thrift.protocol.{TBinaryProtocol, TProtocol}
import org.apache.thrift.transport.{TSocket, TTransport}
import tutorial.MultiplicationService

object MultiplicationClient {

  def main(args: Array[String]): Unit = {
    try {
      val transport: TTransport = new TSocket("localhost", 9090)
      transport.open()

      val protocol: TProtocol = new TBinaryProtocol(transport)
      val client: MultiplicationService.Client = new MultiplicationService.Client(protocol)

      perform(client)

      transport.close()
    }
    catch {
      case e => e.printStackTrace()
    }
  }

  @throws[Exception]
  def perform(client: MultiplicationService.Client): Unit = {
    val product = client.multiply(3, 5)
    println("3 * 5 = " + product)
  }
}
