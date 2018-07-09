import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class test {
	
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

	public static void main(String[] args) {
testStart();
	}

	public static void testStart() {
		Basket basket = new Basket();
		class producer implements Runnable{
			@Override
			public void run() {
				while (true) {
					System.out.println("生产者生产苹果中"+System.currentTimeMillis());
					basket.produce();
					System.out.println("生产者生产苹果结束"+System.currentTimeMillis());
					System.out.println("当前篮子中有苹果: "+basket.getBasketSize()+" 个");
					Thread.sleep(300);
				}
				
			}
		}
		
		class consumer implements Runnable{
			@Override
			public void run() {
				while (true) {
					System.out.println("消费者生产苹果中"+System.currentTimeMillis());
					basket.consume();
					System.out.println("消费者生产苹果结束"+System.currentTimeMillis());
					System.out.println("当前篮子中有苹果: "+basket.getBasketSize()+" 个");
					Thread.sleep(1000);
				}
				
			}
		}
		
		ExecutorService service  = Executors.newCachedThreadPool();
		producer prod = new producer();
		consumer cons = new consumer();
		service.submit(prod);
		service.submit(cons);
		Thread.sleep(10000);
		service.shutdown();
		
	}
}
