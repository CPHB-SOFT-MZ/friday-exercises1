package ex4;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TurnstileCounter {

    static final long DELAY_VAL = 10000;
    long count = 0;

    public long getValue() {
        return count;
    }
    
    //With AtomicLong
//    AtomicLong count = new AtomicLong(0);
//    
//    public AtomicLong getValue(){
//        return count;
//    }
    

    //With lock
    Lock lock = new ReentrantLock();
    public void incr() {
//   If the program initially does not fail, replace the count line with the lines below
//    long n = count;
//    //Spend some time to force preemtion
//    for(long a=0; a<LockDemo.DELAY_VAL; a++);
//    n = n + 1;
//    count = n;
        
        try {
            lock.lock();
            count++;
        } finally {
            lock.unlock();
        }
    }
//  Synchronized 
    /*
    synchronized public void incr() {
//   If the program initially does not fail, replace the count line with the lines below
//    long n = count;
//    //Spend some time to force preemtion
//    for(long a=0; a<LockDemo.DELAY_VAL; a++);
//    n = n + 1;
//    count = n;
        
            count++;
    }
*/
    
//  With AtomicLong
/*        
    public void incr() {
//   If the program initially does not fail, replace the count line with the lines below
//    long n = count;
//    //Spend some time to force preemtion
//    for(long a=0; a<LockDemo.DELAY_VAL; a++);
//    n = n + 1;
//    count = n;
        
            count.getAndIncrement();
    }
*/
    
}
