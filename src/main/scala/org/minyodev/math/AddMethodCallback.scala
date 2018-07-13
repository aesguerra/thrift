package org.minyodev.math

import org.apache.thrift.TException
import org.apache.thrift.async.AsyncMethodCallback
import services.MathOperations

class AddMethodCallback extends AsyncMethodCallback[Integer] {

  override def onComplete(add_call: Integer): Unit = {
    try {
      val result = add_call.intValue()
      println("Result: " + result)
    }
    catch {
      case e: TException => e.printStackTrace()
    }
  }

  override def onError(exception: Exception): Unit = {
    println("Encountered error: " + exception.getMessage)
  }

}
