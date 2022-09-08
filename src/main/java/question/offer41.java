package question;

import java.util.PriorityQueue;

public class offer41 {
}


class MedianFinder {

    PriorityQueue<Integer> queue1;
    PriorityQueue<Integer> queue2;
    // 第一个堆为大顶堆， 第二个为小顶堆；
    // 第一个堆的个数与第二个相等或这差1；
    int size;

    /** initialize your data structure here. */
    public MedianFinder() {
        // 大顶堆
        queue1 = new PriorityQueue<>((a, b) -> b - a);
        // 小顶
        queue2 = new PriorityQueue<>();
    }

    public void addNum(int num) {
        size ++;
        if(queue1.isEmpty() || num <= queue1.peek()){
            queue1.offer(num);
            if(size % 2 == 0){
                queue2.offer(queue1.poll());
            }
        }else{
           queue2.offer(num);
           if(size % 2 == 1){
               queue1.offer(queue2.poll());
           }
        }
    }

    public double findMedian() {
        return size % 2 == 0 ? (queue2.peek() + queue1.peek()) / 2.0 : queue1.peek();
    }
}
