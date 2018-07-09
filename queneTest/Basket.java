import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;

public class Basket {
	
	BlockingDeque< String> basket = (BlockingDeque<String>) new ArrayBlockingQueue<String> (3);
	public void produce() throws InterruptedException {
		basket.put("apple");
	}
	public String consume() throws InterruptedException {
		return basket.take();
	}
	public int getBasketSize() {
		return basket.size();
	}
}
