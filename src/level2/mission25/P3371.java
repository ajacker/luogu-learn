package level2.mission25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * P3371 【模板】单源最短路径（弱化版）
 *
 * @author ajacker
 * @date 2019/12/5 22:53
 */
public class P3371 {

    private static int n, m;
    private static ArrayList<Edge>[] map;

    public static void main(String[] args) {
        n = InputReader.nextInt();
        map = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }
        m = InputReader.nextInt();
        int s = InputReader.nextInt();
        for (int i = 0; i < m; i++) {
            int u = InputReader.nextInt();
            int v = InputReader.nextInt();
            int w = InputReader.nextInt();
            Edge e = new Edge(v, w);
            map[u].add(e);
        }
        int[] res = dij(s);
        for (int i = 1; i <= n; i++) {
            System.out.print(res[i] + " ");
        }
    }

    /**
     * 优先队列 迪杰斯特拉算法
     *
     * @param s
     * @return
     */
    static int[] dij(int s) {
        //标记是否求出了最短路径
        boolean[] visited = new boolean[n + 1];
        //记录最短路径的数组
        int[] distance = new int[n + 1];
        //初始化最大值
        Arrays.fill(distance, Integer.MAX_VALUE);
        //使用优先队列
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        //自己到自己的距离为0
        distance[s] = 0;
        //以自己作为起始点
        queue.add(new Edge(s, 0));
        while (!queue.isEmpty()) {
            //优先队列取出最短路径
            Edge cur = queue.poll();
            int u = cur.v;
            //以最短路径作为中间点更新别的点
            if (!visited[u]) {
                visited[u] = true;
                //遍历以u开始的所有的边
                for (Edge e : map[u]) {
                    int v = e.v;
                    //更新最小距离
                    if (!visited[v] && distance[u] + e.weight < distance[v]) {
                        //如果能够更新最小距离则加入队列
                        distance[v] = distance[u] + e.weight;
                        queue.offer(new Edge(v, distance[v]));
                    }
                }
            }
        }
        return distance;
    }

    static class Edge implements Comparable<Edge> {
        int v;
        int weight;

        public Edge(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static class InputReader {
        private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        private static StringTokenizer tokenizer = null;

        static String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        static int nextInt() {
            return Integer.parseInt(next());
        }

    }
}
