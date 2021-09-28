package base.graph;

import java.util.Scanner;

public class ListGraph {
    private final static int MAX_VEX = 10;

    //边表结点
    private class EdgeNode {
        //对应下标
        int adjvex;
        //权重
        int weight;
        EdgeNode next;
    }

    //顶点表结点
    private class VertexNode {
        char data;
        //边表头指针
        EdgeNode first;
    }

    VertexNode[] adjList;
    int numVertexes, numEdges;

    public void createGraph() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入顶点数：");
        this.numVertexes = scanner.nextInt();
        System.out.print("请输入边数：");
        this.numEdges = scanner.nextInt();
        this.adjList=new VertexNode[numVertexes];
        //初始化边表
        for (int i = 0; i < numVertexes; i++) {
            this.adjList[i]=new VertexNode();
        }
        //建立边表
        for (int i = 0; i < numVertexes; i++) {
            this.adjList[i].data=scanner.next().charAt(0);
            //边表置空
            this.adjList[i].first=null;
        }
        //建立边表
        for (int i = 0; i < numEdges; i++) {
            System.out.println("请输入坐标及权重（1,1,4）");
            String[] split = scanner.next().split(",");
            int a =Integer.parseInt(split[0]);
            int b =Integer.parseInt(split[1]);
            int c =Integer.parseInt(split[2]);

            EdgeNode node1 = new EdgeNode();
            node1.weight=c;
            node1.adjvex=b;
            node1.next=this.adjList[a].first;
            this.adjList[a].first=node1;

            EdgeNode node2 = new EdgeNode();
            node2.weight=c;
            node2.adjvex=a;
            node2.next=this.adjList[b].first;
            this.adjList[b].first=node2;
        }
    }

    public static void main(String[] args) {
        ListGraph listGraph = new ListGraph();
        listGraph.createGraph();
        for (int i = 0; i < listGraph.numVertexes; i++) {
            EdgeNode temp=listGraph.adjList[i].first;
            while (temp!=null){
                System.out.printf("%4d  ",temp.adjvex);
                temp=temp.next;
            }
            System.out.println();
        }
    }
}
