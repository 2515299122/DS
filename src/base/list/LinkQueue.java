package base.list;

class LinkQueue {
    LNode rear;
    LNode front;

    LinkQueue() {
        this.rear = this.front = null;
    }

    public boolean isEmpty() {
        return this.rear == null || this.front == null;
    }

    public void enQueue(int e) {
        LNode node = new LNode();
        node.data = e;
        node.next = null;
        if (this.rear == null) {
            rear = front = node;
        } else {
            rear.next = node;
            rear = rear.next;
        }
    }
    
    public int deQueue(){
        LNode node;
        if(this.rear==null)
            throw new RuntimeException();
        else 
            node=this.front;
        if(this.rear==this.front)
            this.rear=this.front=null;
        else 
            this.front=this.front.next;
        return node.data;
    }

    public static void main(String[] args) {
        LinkQueue linkQueue = new LinkQueue();
        for (int i = 0; i < 10; i++) {
            linkQueue.enQueue(i+1);
        }
        linkQueue.deQueue();
        linkQueue.enQueue(999);
        while (!linkQueue.isEmpty()){
            System.out.print(linkQueue.deQueue()+" ");
        }
    }


    static class LNode {
        int data;
        LNode next;
    }
}
