package TestAbout;


public class ThreadTasks {
	
	public static int num = 1;
	
	public static class MyThread1 extends Thread{
		@Override
		public void run() {
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			num = num + 1;
			System.out.print(num + " ");
		}
	}
	
	public static class MyThread2 extends Thread{
		@Override
		public void run() {
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			num = num + 1;
			System.out.print(num + " ");
		}
	} 
	
	
	public static void main(String[] args) throws InterruptedException {
		int n = 0;
		while(n < 1000) {
			Thread t1 = new MyThread1();
			Thread t2 = new MyThread2();
			t1.start();
			t2.start();
			t1.join();
			t2.join();
			n += 1;
			num = 1;
			System.out.println();
		}
	}
}
