package org.minyodev.math

import org.apache.thrift.server.TThreadPoolServer
import org.apache.thrift.transport.TServerSocket
import services.MathOperations
import services.MathOperations.Iface

object MathOperationsServer {

  def start(port: Int): Unit = {
    val serverTransport: TServerSocket = new TServerSocket(port)
    val processor: MathOperations.Processor[Iface] = new MathOperations.Processor(new MathOperationsHandler())
    val server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor))
    println("Starting server ...")
    server.serve()
  }

  def main(args: Array[String]): Unit = {
    start(9090)
  }
}
