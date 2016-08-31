/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turnstileserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mikkel
 */
public class Monitor implements Runnable{
    @Override
    public void run() {
        try {
            startSocketServer();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void startSocketServer() throws IOException{
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(8090));
        while(true){
            Socket connection = server.accept();
            BufferedReader inputStream  = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = inputStream.readLine();
            System.out.println(line);
        }
    }
    
}
