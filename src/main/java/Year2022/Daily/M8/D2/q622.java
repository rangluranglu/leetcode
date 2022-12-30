package Year2022.Daily.M8.D2;

public class q622 {
}


class MyCircularQueue {
    int[] queue;
    int front;
    int rear;
    int capacity;

    public MyCircularQueue(int k) {
        capacity = k + 1;
        queue = new int[capacity];
        front = rear = 0;
    }

    // 向队尾插入一个元素
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        queue[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }
    // 删除一个元素
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        front = (front + 1) % capacity;
        return true;

    }

    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return queue[front];
    }

    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return queue[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }
}