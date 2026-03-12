package server

import java.net.ServerSocket
import java.io.{BufferedInputStream, BufferedOutputStream, PrintStream}

object SimpleNetwork  {
  def main(args: Array[String]): Unit = {
    val ss = new ServerSocket(4111);
    val sock = ss.accept(); 
    val inputStream = new BufferedInputStream(sock.getInputStream());
    val outputStream = new PrintStream(new BufferedOutputStream(sock.getOutputStream()));
    outputStream.println("Hello World");
    //sleep for checking for input
    while(inputStream.available()<1) { Thread.sleep(100) }
    val buffer = new Array.[Byte](inputStream.available())
    inputStream.read(buffer);
    val input = new String(buffer);
    println(input)
    outputStream.println(input);
    //always close a socket when not used
    ss.close();
  }
}
