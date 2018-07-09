import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class test {
	

	public static void main(String[] args) {
			testStart();
	}

	public static void testStart() {
		Basket basket =new Basket ();
		class producer extends Thread{
			volatile  boolean stop = false;
			@Override
			public void run() {
				while (!stop) {
					try {
						basket.produce();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("生产苹果结束");
					System.out.println("当前篮子中有苹果: "+basket.getBasketSize()+" 个");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		}
		
		class consumer extends Thread{
			volatile  boolean stop = false;
			@Override
			public void run() {
				while (!stop) {
					
					try {	
						Thread.sleep(2000);
						if (basket.consume().equals("apple")) {
							System.out.println("消费苹果成功");
							System.out.println("当前篮子中有苹果: "+basket.getBasketSize()+" 个");
						}else {
							System.out.println("等待苹果");
						}
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		}
		
		ExecutorService service  = Executors.newCachedThreadPool();
		producer prod = new producer();
		consumer cons = new consumer();
		service.submit(prod);
		service.submit(cons);
		try {
		
			Thread.sleep(10000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		service.shutdown();
		
	}
}
