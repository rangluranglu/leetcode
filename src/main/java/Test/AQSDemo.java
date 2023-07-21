package Test;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyThread3 extends Thread{
    private Lock lock;

    public MyThread3(String name, Lock lock){
        super(name);
        this.lock = lock;
    }

    public void run(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread() + "running");
        }finally {
            lock.unlock();
        }
    }
}
public class AQSDemo {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        MyThread3 t1 = new MyThread3("t1", lock);
        MyThread3 t2 = new MyThread3("t2", lock);

        t1.start();
        t2.start();

    }
}
