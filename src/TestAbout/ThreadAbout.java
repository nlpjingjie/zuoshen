package TestAbout;

//�߳�
public class ThreadAbout {
 public static void main(String[] args) {
	 // 1.ʹ��lambda���ʽ�����߳�
     /*Thread t = new Thread(() -> {
         System.out.println("start new thread!");
     });*/
	 
//	 Thread t = new MyThread(); 
	 
	 Thread t = new Thread(new MyRunnable());
     t.start(); // �������߳�
 }
 
 // 2.�̳�Thread��
 static class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("start new thread!");
    }
}
}

// 3.ʵ��Runnable�ӿ�
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("start new thread!");
    }
}
