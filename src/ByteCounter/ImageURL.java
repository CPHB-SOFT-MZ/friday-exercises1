/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ByteCounter;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mikkel
 */
public class ImageURL extends Thread{
    
    private String url;
    private int sum = 0;
    
    public ImageURL(String url){
        this.url = url;
    }
    
    @Override
    public void run(){
        try {
            calc(getBytesFromImage());
        } catch (Exception ex) {
            //Logger.getLogger(ImageURL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private byte[] getBytesFromImage() throws Exception{
        
        URLConnection connection = new URL(url).openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        connection.connect();
        ByteArrayOutputStream bis = new ByteArrayOutputStream();
        InputStream is = connection.getInputStream();
        byte[] bytes = new byte[4096];
        int read;
        while ((read = is.read(bytes)) > 0) {
                bis.write(bytes, 0, read);
        }
        return bis.toByteArray();
    }
    
    
    private void calc(byte[] bytes){
        for(int i = 0; i < bytes.length; i++){
            this.sum = this.sum + bytes[i];
        }
    }
    
    public  int getSum(){
        return sum;
    }
}
