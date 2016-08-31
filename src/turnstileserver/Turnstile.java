package turnstileserver;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import turnstileserver.TurnstileCounter;
import turnstileserver.TurnstileCounter;


public class Turnstile implements Runnable{
  //private final TurnstileCounter counter;
  private int count;

  final int COUNT_MAX = 1000;

  Turnstile() {
      
  }

  public int getCount() {
    return count;
  }

  @Override
  public void run() {
      try {
          //System.out.println("Thread has started");
          clientServer();
      } catch (IOException ex) {
          Logger.getLogger(Turnstile.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  
  private void clientServer() throws IOException{
      Socket socket = new Socket();
      SocketAddress address = new InetSocketAddress("localhost", 8090);
      socket.connect(address);
      OutputStream outputStream = socket.getOutputStream();
      outputStream.write("I'm a turnstile \n".getBytes());
      //System.out.println("Turnstile has connected");
  }
  
}
