/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fridayexercises;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mikkel
 */
public class FridayExercises {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Exercise1 ex1 = new Exercise1();
        
        Runnable ex2Runnable = () -> System.out.println("Runnable 1: " + ex1.next());
        
        Runnable ex2Runnable2 = () -> System.out.println("Runnable 2: " + ex1.next());
        
        //This will not always return an even number since they modify the same int
        //The issue is pretty common, since you have to take precautions to make sure the mothod is thread safe. 
        //The method is now synchronized and the integer is atomic. It's now thread safe. 
        //The moethoid can return will return 4 and 4 or 2 and 4 since we don't know when each thread will stop and when it will return the value.
        //It will always be an even number though.
        new Thread(ex2Runnable).start();
        new Thread(ex2Runnable2).start();
        
        
//        ex1.runEx1();
        
//        try {
//            Thread.sleep(10000);
//            ex1.run = new AtomicBoolean(false);
//        } catch (InterruptedException ex) {
//
//        }
        
        
        
    }


}

      
