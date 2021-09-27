package base.list;

class LinkStack {
    LNode next;

    public boolean isEmpty() {
        return this.next == null;
    }

    public void push(int e) {
        LNode lNode = new LNode();
        lNode.data = e;
        lNode.next = this.next;
        this.next = lNode;
    }

    public int pop() {
        if (this.next == null) throw new RuntimeException();
        LNode lNode = this.next;
        this.next=lNode.next;
        return lNode.data;
    }

    public static void main(String[] args) {
        LinkStack linkStack = new LinkStack();
        for (int i = 0; i < 10; i++) {
            linkStack.push(i + 1);
        }
        linkStack.pop();
        linkStack.push(999);
        while (!linkStack.isEmpty()) {
            System.out.print(linkStack.pop() + " ");
        }
    }


    private class LNode {
        int data;
        LNode next;
    }
}
