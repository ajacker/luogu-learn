package level3.mission10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * P1991 无线通讯网
 *
 * @author ajacker
 * @date 2019/12/7 11:57
 */
public class P1991 {

    private static int S, P;
    /**
     * 并查集，查询节点归属
     */
    private static int[] parent;
    /**
     * 点集
     */
    private static ArrayList<Point> points = new ArrayList<>();
    /**
     * 边集
     */
    private static ArrayList<Edge> edges = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.nextInt();
        P = sc.nextInt();
        parent = new int[P + 1];
        //一开始所有点属于自己
        for (int i = 1; i <= P; i++) {
            parent[i] = i;
        }
        for (int i = 1; i <= P; i++) {
            //加入点集
            Point point = new Point(sc.nextInt(), sc.nextInt(), i);
            //连接所有点，构造可能的边
            for (Point other : points) {
                edges.add(new Edge(point, other));
            }
            points.add(point);
        }
        //按照长度从小到大排序
        Collections.sort(edges);
        int count = 0;
        //选择不构成回路的边构造最小生成树
        for (Edge e : edges) {
            if (union(e.u, e.v)) {
                //如果到了P-1个就是最小生成树，将剩余的部分用卫星电话，所以还要再减去S个边（他们用卫星电话）
                if (count++ == P - 1 - S) {
                    System.out.printf("%.2f", e.len);
                    System.exit(0);
                }
            }
        }
    }

    /**
     * 并查集路径压缩，查找归属
     *
     * @param i 要查找的点编号
     * @return 归属类别编号
     */
    static int find(int i) {
        return i == parent[i] ? i : (parent[i] = find(parent[i]));
    }

    /**
     * 尝试连接两个点
     *
     * @param u u
     * @param v v
     * @return 是否可合并
     */
    static boolean union(Point u, Point v) {
        int a = find(u.id);
        int b = find(v.id);
        if (a == b) {
            return false;
        } else {
            parent[a] = b;
            return true;
        }
    }

    /**
     * 边
     */
    static class Edge implements Comparable<Edge> {
        Point u, v;
        double len;

        public Edge(Point u, Point v) {
            this.u = u;
            this.v = v;
            //两点之间距离公式，计算长度
            this.len = Math.sqrt(Math.pow(u.x - v.x, 2) + Math.pow(u.y - v.y, 2));
        }

        /**
         * 比较两个边的长度
         *
         * @param o 另一条边
         * @return 小于返回-，大于返回+，等于返回0
         */
        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.len, o.len);
        }
    }

    /**
     * 点
     */
    static class Point {
        /**
         * 坐标（x，Y）
         */
        int x, y;
        /**
         * 点编号
         */
        int id;

        public Point(int x, int y, int id) {
            this.x = x;
            this.y = y;
            this.id = id;
        }
    }

}
