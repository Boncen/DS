import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;

public class Basket {
	
	ArrayBlockingQueue<String> basket = new ArrayBlockingQueue<String> (3);
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
