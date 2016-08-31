package turnstileserver;



public class Tester {
 static final int NUMBER_OF_TURNSTILES = 40;
  static Turnstile[] turnStiles = new Turnstile[NUMBER_OF_TURNSTILES];
  static int counter = 0;
  public static void main(String[] args) throws InterruptedException {
    //This is the shared Counter used by all turnstilles
    
    //new Thread(() -> new Monitor()).start();
    Thread server = new Thread(new Monitor());
    server.start();
      System.out.println("Server started");
    
    TurnstileCounter sharedCounter = new TurnstileCounter();
    

    for (int i = 0; i < NUMBER_OF_TURNSTILES; i++) {
        Thread client = new Thread(new Turnstile());
        client.start();
        counter++;
        //System.out.println("Creating turnstiles");
      //new Thread(() -> new Turnstile()).start();
      
    }

    
    
    //This example uses a ThreadPool to handle threads
    
    //ExecutorService es=Executors.newCachedThreadPool();
   
    /*
    for (int i = 0; i < NUMBER_OF_TURNSTILES; i++) {
      es.execute(turnStiles[i]);
    }
    */
    
    //es.shutdown();
    //es.awaitTermination(10, TimeUnit.SECONDS);
    
    server.join();
    System.out.println("All turnstiles are done");
    //Print the updated value
    System.out.println(sharedCounter.getValue());
  }  
}


