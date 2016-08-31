/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fridayexercises;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Mikkel
 */
public class Exercise1 {

    AtomicBoolean run = new AtomicBoolean(true);

    private AtomicInteger n = new AtomicInteger(0);
   
    public void runEx1() {

        Runnable sumToOneB = () -> {
            long sum = 0;
            long max = 1000000000;
            for (long i = 1; i <= max; i++) {
                sum = sum + i;
            }
            System.out.println("Sum: " + sum);
        };

        Runnable oneToFive = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(i);
                if (i < 5) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {

                    }
                }
            }
        };
        Runnable fromTen = () -> {
            int i = 10;
            while (run.get()) {
                System.out.println(i);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {

                }
                i++;
            }
        };
        new Thread(sumToOneB).start();
        new Thread(oneToFive).start();
        new Thread(fromTen).start();
    }
    
    synchronized public AtomicInteger next(){
        n.incrementAndGet();
        n.incrementAndGet();
        return n;
    }

}
