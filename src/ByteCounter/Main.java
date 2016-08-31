/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ByteCounter;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Mikkel
 */
public class Main {
    public static void main(String[] args) throws Exception {
        String url1 = "https://fronter.com/cphbusiness/design_images/images.php/Classic/login/fronter_big-logo.png";
        String url2 = "https://fronter.com/cphbusiness/design_images/images.php/Classic/login/folder-image-transp.png";
        String url3 = "https://fronter.com/volY12-cache/cache/img/design_images/Classic/other_images/button_bg.png";
        
        ImageURL img1 = new ImageURL(url1);
        ImageURL img2 = new ImageURL(url2);
        ImageURL img3 = new ImageURL(url3);
       
        long start = System.nanoTime();
        img1.start();
        img2.start();
        img3.start();
        img3.join();
        img2.join();
        img1.join();
        long end = System.nanoTime();
        System.out.println("Time Sthreaded: "+(end-start));
        
        
        /*
        long start = System.nanoTime();
        img1.run();
        img2.run();
        img3.run();
        long end = System.nanoTime();
        System.out.println("Time Sequental: "+(end-start));
        */
        System.out.println(img1.getSum() + img2.getSum() + img3.getSum());
        
        
    }
}
