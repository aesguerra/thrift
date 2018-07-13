package org.minyodev.math

import org.apache.thrift.server.TThreadPoolServer
import org.apache.thrift.transport.TServerSocket
import services.MathOperations
import services.MathOperations.Iface

object MathOperationsServer {

  def main(args: Array[String]): Unit = {
    val serverTransport: TServerSocket = new TServerSocket(9090)
    val processor: MathOperations.Processor[Iface] = new MathOperations.Processor(new MathOperationsHandler())
    val server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor))

    println("Starting server ...")
    server.serve()
    println("---")
  }
}
