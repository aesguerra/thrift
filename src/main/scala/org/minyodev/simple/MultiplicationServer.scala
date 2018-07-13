package org.minyodev.simple

import org.apache.thrift.server.TServer.Args
import org.apache.thrift.server.{TServer, TSimpleServer}
import org.apache.thrift.transport.{TServerSocket, TServerTransport}
import tutorial.MultiplicationService
import tutorial.MultiplicationService.Iface

object MultiplicationServer {

  def main(args: Array[String]) {
    try {
      val handler: MultiplicationHandler = new MultiplicationHandler()
      val processor: MultiplicationService.Processor[Iface] = new MultiplicationService.Processor(handler)

      val s: Runnable = new Runnable() {
        def run() {
          simple(processor)
        }
      }

      new Thread(s).start();
    } catch {
      case x => x.printStackTrace();
    }
  }

  def simple(processor: MultiplicationService.Processor[Iface]) {
    try {
      val serverTransport: TServerTransport = new TServerSocket(9090)
      val server: TServer = new TSimpleServer(new Args(serverTransport).processor(processor))

      System.out.println("Starting the simple server...")
      server.serve()
    } catch {
      case e => e.printStackTrace()
    }
  }
}
