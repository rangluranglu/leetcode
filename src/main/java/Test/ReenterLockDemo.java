package Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReenterLockDemo {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock(true);

        MyThread4 t1 = new MyThread4("t1", lock);
        MyThread4 t2 = new MyThread4("t2", lock);
        MyThread4 t3 = new MyThread4("t3", lock);

        t1.start();
        t2.start();
        t3.start();
    }
}

class MyThread4 extends Thread{
    private Lock lock;

    public MyThread4(String name, Lock lock){
        super(name);
        this.lock = lock;
    }

    public void run(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " running");

            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }
    }
}
