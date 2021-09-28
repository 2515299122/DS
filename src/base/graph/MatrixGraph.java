package base.graph;

import java.util.Scanner;

public class MatrixGraph {
    //最大顶点数
    private final static int MAX_VEX = 10;
    private final static int INFINITY = 65535;
    //顶点表
    char[] vexs;
    //邻接矩阵
    int[][] arc;
    //标记
    int numVertexes, numEdges;

    MatrixGraph() {
        this.vexs = new char[MAX_VEX];
        this.arc = new int[MAX_VEX][MAX_VEX];
    }

    public void createGraph() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入顶点数：");
        this.numVertexes = scanner.nextInt();
        System.out.print("请输入边数：");
        this.numEdges = scanner.nextInt();
        System.out.println("请输入顶点数据，用,隔开");
        String[] s = scanner.next().split(",");
        //建立顶点表
        for (int i = 0; i < numVertexes; i++) {
            this.vexs[i] = s[i].charAt(0);
        }
        //初始化为无穷
        for (int i = 0; i < numVertexes; i++) {
            for (int i1 = 0; i1 < numVertexes; i1++) {
                this.arc[i][i1] = INFINITY;
            }
        }
        //建立边
        for (int i = 0; i < numEdges; i++) {
            System.out.println("请输入坐标及权重（1,1,4）");
            String[] split = scanner.next().split(",");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            int c = Integer.parseInt(split[2]);
            this.arc[a][b] = this.arc[b][a] = c;
        }
    }
//    ========================      深度优先遍历开始    ==========================
    boolean[] flags;
    private void DFS(int index) {
        flags[index]=true;
        System.out.print(vexs[index]+" ");
        //遍历该节点的未访问的边结点
        for (int j = 0; j < numVertexes; j++) {
            if(arc[index][j]!=INFINITY&&!flags[j]){
                DFS(j);
            }
        }
    }

    public void DFSTraverse(){
        this.flags=new boolean[numVertexes];
        for (int i = 0; i < numVertexes; i++) {
            if(!flags[i])
                DFS(i);
        }
    }
//    ========================      深度优先遍历结束    ==========================



    public static void main(String[] args) {
        MatrixGraph matrixGraph = new MatrixGraph();
        matrixGraph.createGraph();
        for (int i = 0; i < matrixGraph.numVertexes; i++) {
            for (int i1 = 0; i1 < matrixGraph.numVertexes; i1++) {
                System.out.printf("%5d  ", matrixGraph.arc[i][i1]);
            }
            System.out.println();
        }
        System.out.println();
        matrixGraph.DFSTraverse();
    }
}
