package Test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<>(new Task());

        Thread thread = new Thread(futureTask);
        thread.setName("Task thread");
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread" + Thread.currentThread().getName() + " is running");

        if(!futureTask.isDone()){
            System.out.println("Task is not finished, please wait");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int result = 0;
        try {
            result = futureTask.get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("result is " + result);
    }


    static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("Thread" + Thread.currentThread().getName() + " is running");

            int result = 0;
            for (int i = 0; i < 100; i++) {
                result += i;
            }

            Thread.sleep(3000);
            return result;
        }
    }
}
