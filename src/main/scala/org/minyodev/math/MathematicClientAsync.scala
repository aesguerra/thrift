package org.minyodev.math

import org.apache.thrift.TException
import org.apache.thrift.async.{AsyncMethodCallback, TAsyncClientManager}
import org.apache.thrift.protocol.{TBinaryProtocol, TProtocol}
import org.apache.thrift.transport.{TNonblockingSocket, TSocket, TTransport, TTransportException}
import services.MathOperations

object MathematicClientAsync {

  def add(a: Int, b: Int): Unit = {
    try {
      val client: MathOperations.AsyncClient = new MathOperations.AsyncClient(
        new TBinaryProtocol.Factory(), new TAsyncClientManager(),
        new TNonblockingSocket("localhost", 9090)
      )

      val amc: AsyncMethodCallback[Integer] = new AddMethodCallback()

      client.add(a, b, amc)

      amc.onComplete(200)
      amc.onError(throw new Exception("Wuuut?"))

    }
    catch {
      case e: TTransportException => e.printStackTrace()
        0
      case e: TException => e.printStackTrace()
        0
      case e: Exception => println("???")
    }
  }

  def main(args: Array[String]): Unit = {
    println("Calling add()...")
    add(1, 2)
    println("Called! add()...")
  }
}
