package serdestudy

import java.io._

object LoanPattern {

  def useFileInputStream[A](filename: String)(body: FileInputStream => A): A = {
    val fis = new FileInputStream(filename)
    try {
      body(fis)
    } finally {
      fis.close()
    }
  }

  def withDOS[A](filename: String)(body: DataOutputStream => A): A = {
    val dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))
    try {
      body(dos)
    } finally {
      dos.close()
    }
  }

  def withDIS[A](filename: String)(body: DataInputStream => A): A = {
    val dis = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)))
    try {
      body(dis)
    } finally {
      dis.close()
    }
  }

  def withOOS[A](filename: String)(body: ObjectOutputStream => A): A = {
    val oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))
    try {
      body(oos)
    } finally {
      oos.close()
    }
  }

  def withOIS[A](filename: String)(body: ObjectInputStream => A): A = {
    val ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)))
    try {
      body(ois)
    } finally {
      ois.close()
    }
  }
}
