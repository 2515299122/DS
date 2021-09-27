package base.list;

class LinkList {
    LNode head;

    LinkList() {
        head = new LNode();
        head.next = null;
    }

    public void insertHead(int data) {
        LNode lNode = new LNode();
        lNode.data = data;
        lNode.next = head.next;
        head.next = lNode;
    }

    public int delete(int index) {
        if (head.next == null || index < 1) throw new RuntimeException();
        LNode temp = head;
        int p = 1;
        while (temp != null && p < index) {
            temp = temp.next;
            p++;
        }
        if (temp == null || p > index) {
            throw new RuntimeException();
        }
        LNode node = temp.next;
        temp.next = node.next;
        return node.data;
    }

    public void insert(int index, int e) {
        if (index < 1) throw new RuntimeException();
        int p = 1;
        LNode temp = head;
        while (temp != null && p < index) {
            temp = temp.next;
            p++;
        }
        if (temp == null || p > index) {
            throw new RuntimeException();
        }
        LNode lNode = new LNode();
        lNode.data = e;
        lNode.next = temp.next;
        temp.next = lNode;
    }

    public void show() {
        LNode node = head.next;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        for (int i = 0; i < 10; i++) {
            linkList.insertHead(i + 1);
        }
        linkList.delete(9);
//        linkList.delete(0);
        linkList.show();
        System.out.println();
        linkList.insert(9, 999);
        linkList.show();

    }


    class LNode {
        int data;
        LNode next;
    }
}
