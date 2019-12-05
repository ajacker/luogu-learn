package level2.mission25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * P3366 【模板】最小生成树
 *
 * @author ajacker
 * @date 2019/12/5 17:11
 */
public class P3366 {

    private static int n;
    private static int m;
    private static int[] parent;
    private static Edge[] edges;

    public static void main(String[] args) {
        n = InputReader.nextInt();
        m = InputReader.nextInt();
        parent = new int[n + 1];
        edges = new Edge[m];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            edges[i] = new Edge(InputReader.nextInt(), InputReader.nextInt(), InputReader.nextInt());
        }
        Arrays.sort(edges);
        int count = 0, res = 0, i = 0;
        while (count < n - 1 && i < m) {
            Edge edge = edges[i++];
            if (union(edge.u, edge.v)) {
                res += edge.length;
                count++;
            }
        }
        System.out.print(count == n - 1 ? res : "orz");

    }

    private static int find(int i) {
        return parent[i] == i ? i : (parent[i] = find(parent[i]));

    }

    private static boolean union(int u, int v) {
        int a = find(u);
        int b = find(v);
        if (a == b) {
            return false;
        } else {
            parent[a] = b;
            return true;
        }
    }

    static class Edge implements Comparable<Edge> {
        int u, v, length;

        public Edge(int u, int v, int length) {
            this.u = u;
            this.v = v;
            this.length = length;
        }

        @Override
        public int compareTo(Edge o) {
            return this.length - o.length;
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
