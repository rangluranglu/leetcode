package Test;

public class WaitAndNotifyDemo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        synchronized (myThread) {
            try {
                myThread.start();
                // 主线程
                Thread.sleep(3000);
                System.out.println("before wait");
                // 主线程等待
                myThread.wait();
                System.out.println("after wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}


class MyThread extends Thread {
    public void run() {
        synchronized (this) {
            System.out.println("before notify");
            notify();
            System.out.println("after notify");
        }
    }
}


