package threads;

import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

interface MessagePrinterService
{
    public void print(String message);
	default void sleep(int mse) {
		try
        {
            Thread.sleep(mse);
        } catch (InterruptedException ex)
        {
            //ignore
        }
	}
}

class AnnoyedMessagePrinterService implements MessagePrinterService
{
    @Override
    public void print(String message)
    {
        sleep(5000);
        System.out.println("What now??****? ".concat(message));
    }

}

class BlockCapitalsMessagePrinterService implements MessagePrinterService
{
 
    @Override
    public void print(String message)
    {
        sleep(4000);
        System.out.println(message.toUpperCase());
        throw new RuntimeException("Go F");
    }
     
}
public class CompletableDemo {

	public static void main(String[] args) {

		ExecutorService threadPool = Executors.newFixedThreadPool(3);
	    MessagePrinterService annoyed = new AnnoyedMessagePrinterService();
	    MessagePrinterService blockCapitals = new BlockCapitalsMessagePrinterService();
	    String message = "My latest invention is going to save the world!";
	    CompletableFuture<Void> annoyedTask = CompletableFuture.runAsync(() -> annoyed.print(message), threadPool);
	    CompletableFuture<Void> blockCapitalsTask = CompletableFuture.runAsync(() -> blockCapitals.print(message), threadPool);
	    Instant start = Instant.now();
	    
	    CompletableFuture.allOf(annoyedTask, blockCapitalsTask).
	    exceptionally((ex)->{
	    	System.out.println("exception occured "+ex.getMessage());
	    	return null;
	    }).
	    thenRun(()->System.out.println("all jobs done"));
	    threadPool.shutdown();
	    
	}

}
