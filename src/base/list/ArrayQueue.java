package base.list;

class ArrayQueue {
    int MAXSIZE;
    int[] data;
    int rear, front;

    ArrayQueue() {
        this.MAXSIZE = 100;
        this.rear = this.front = 0;
        this.data = new int[MAXSIZE];
    }

    ArrayQueue(int MAXSIZE) {
        this.MAXSIZE = MAXSIZE;
        this.rear = this.front = 0;
        this.data = new int[MAXSIZE];
    }

    public boolean isEmpty() {
        return this.rear == this.front;
    }

    public boolean enQueue(int e) {
        if ((rear + 1) % MAXSIZE == front) {
            return false;
        }
        rear = (rear + 1) % MAXSIZE;
        data[rear]=e;
        return true;
    }

    public Integer deQueue(){
        if(rear==front) return null;
        front=(front+1)%MAXSIZE;
        return data[front];
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue();
        for (int i = 0; i < 10; i++) {
            arrayQueue.enQueue(i+1);
        }
        arrayQueue.deQueue();
        arrayQueue.enQueue(999);
        while (!arrayQueue.isEmpty()){
            System.out.print(arrayQueue.deQueue()+" ");
        }

    }

}
