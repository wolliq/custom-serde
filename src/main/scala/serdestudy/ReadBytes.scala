package serdestudy

import java.io.{FileNotFoundException, IOException}

object ReadBytes extends App {

  try {
    LoanPattern.useFileInputStream("src/main/scala/serdestudy/ReadBytes.scala") { fis =>
      var byte = fis.read()
      while (byte > 0) {
        print(byte + " ")
        byte = fis.read()
      }
      println()
    }
  } catch {
    case e: IOException =>
      println("Something else went wrong with IO.")
      e.printStackTrace()
    case e: FileNotFoundException =>
      println("The file isn't there.")
      e.printStackTrace()
  }
}
