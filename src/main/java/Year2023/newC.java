package Year2023;

import java.util.concurrent.atomic.AtomicInteger;

// 百度二面
public class newC {
    static AtomicInteger atomicInteger = new AtomicInteger();
    static volatile int state = 0;
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Object obj = new Object();
        myThread thread1 = new myThread(obj, 0);
        myThread thread2 = new myThread(obj, 1);
        myThread thread3 = new myThread(obj, 2);

        thread1.next = thread2;
        thread2.next = thread3;
        thread3.next = thread1;

        thread1.start();
        thread2.start();
        thread3.start();
    }

    static class myThread extends Thread{
        Object lock;

        int id;
        Thread next;

        public  myThread(Object obj, int id){
            this.lock = obj;
            this.id = id;
        }

        @Override
        public void run(){
            synchronized (lock){
                while (atomicInteger.get() <= 100){
                    if(id == state % 3){
                        System.out.println(this.getId() + "--" + atomicInteger.get());
                        atomicInteger.getAndAdd(1);
                        state += 1;
                    }
                    lock.notifyAll();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }
    }



}

class Singleton{

    public static Singleton singleton = new Singleton();

    private Singleton(){

    }
    public static Singleton getSingleton(){
        return singleton;
    }
}
