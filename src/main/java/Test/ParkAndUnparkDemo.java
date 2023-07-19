package Test;

import java.util.concurrent.locks.LockSupport;

class MyThread2 extends Thread {

    private Object object;

    public MyThread2(Object object) {
        this.object = object;
    }

    public void run() {
        System.out.println("before unpark");

        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        // 获取blocker
        System.out.println("blocker info" + LockSupport.getBlocker((Thread) object));
        // 释放许可
        LockSupport.unpark((Thread) object);

        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("blocker info" + LockSupport.getBlocker((Thread) object));
        System.out.println("after unpark");
    }
}

public class ParkAndUnparkDemo {
    public static void main(String[] args) {
        MyThread2 myThread = new MyThread2(Thread.currentThread());

        myThread.start();
        System.out.println("before park");

        // 主线程park
        LockSupport.park("ParkAndUnparkDemo");

        System.out.println("after park");
    }
}
