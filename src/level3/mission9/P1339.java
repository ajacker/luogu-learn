package level3.mission9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * P1339 [USACO09OCT]热浪Heat Wave
 *
 * @author ajacker
 * @date 2019/12/10 16:20
 */
public class P1339 {

    private static int n;
    private static int m;
    private static int s;
    private static int t;
    private static ArrayList<Edge>[] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        s = sc.nextInt();
        t = sc.nextInt();
        map = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            map[u].add(new Edge(v, w));
            map[v].add(new Edge(u, w));
        }
        dij(s, t);
    }

    static void dij(int s, int t) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[s] = 0;
        visited[s] = true;
        queue.offer(new Edge(s, 0));
        while (!queue.isEmpty()) {
            Edge e = queue.poll();
            int u = e.v;
            for (Edge next : map[u]) {
                int v = next.v;
                if (!visited[v] && dis[u] + next.w < dis[v]) {
                    dis[v] = dis[u] + next.w;
                    queue.offer(new Edge(v, dis[v]));
                }
            }
        }
        System.out.println(dis[t]);
    }

    static class Edge implements Comparable<Edge> {
        int v, w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }
}
