package level3.mission10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * P1546 最短网络 Agri-Net
 * 最小生成树
 *
 * @author ajacker
 * @date 2019/12/8 21:54
 */
public class P1546 {

    private static int N;
    private static int[] parent;
    private static ArrayList<Edge> edges = new ArrayList<>();

    public static void main(String[] args) {
        N = InputReader.nextInt();
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int w = InputReader.nextInt();
                if (i != j) {
                    edges.add(new Edge(i, j, w));
                }
            }
        }
        Collections.sort(edges);
        int count = 0;
        int ans = 0;
        for (Edge edge : edges) {
            if (union(edge.u, edge.v)) {
                count++;
                ans += edge.weight;
                if (count == N - 1) {
                    System.out.print(ans);
                    System.exit(0);
                }
            }
        }
    }

    static int find(int i) {
        return i == parent[i] ? i : (parent[i] = find(parent[i]));
    }

    static boolean union(int u, int v) {
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
        int u, v, weight;

        public Edge(int u, int v, int weight) {
            this.v = v;
            this.u = u;
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
