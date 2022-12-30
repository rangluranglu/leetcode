package Year2022.Daily.M8.D15;

public class q641 {
}

class MyCircularDeque {

    int[] queue;
    int front, last;
    int size;

    public MyCircularDeque(int k) {
        queue = new int[k + 1];
        this.front = 0;
        this.last = 0;
        this.size = k + 1;
    }
    // front >= last;
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }

        queue[front] = value;
        front = (front + 1) % size;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        last = (last - 1 + size)  % size;
        queue[last] = value;
        return true;
    }

    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        front = (front - 1 + size) % size;

        return true;
    }

    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }

        last = (last + 1) % size;
        return true;
    }

    public int getFront() {
        if(isEmpty()){
            return -1;
        }

        return queue[(front - 1 + size) % size];
    }

    public int getRear() {
        if(isEmpty()){
            return -1;
        }

        return queue[last];
    }

    public boolean isEmpty() {
        return front == last;
    }

    public boolean isFull() {
        return  (front + 1) % size == last;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */