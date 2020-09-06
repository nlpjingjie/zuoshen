package TestAbout;

//线程
public class ThreadAbout {
 public static void main(String[] args) {
	 // 1.使用lambda表达式创建线程
     /*Thread t = new Thread(() -> {
         System.out.println("start new thread!");
     });*/
	 
//	 Thread t = new MyThread(); 
	 
	 Thread t = new Thread(new MyRunnable());
     t.start(); // 启动新线程
 }
 
 // 2.继承Thread类
 static class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("start new thread!");
    }
}
}

// 3.实现Runnable接口
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("start new thread!");
    }
}
