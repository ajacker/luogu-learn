package level3.mission10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * P2330 [SCOI2005]繁忙的都市
 *
 * @author ajacker
 * @date 2019/12/9 0:33
 */
public class P2330 {
    /**
     * n个交叉路口
     */
    private static int n;
    /**
     * m条道路
     */
    private static int m;
    private static int[] parent;
    private static ArrayList<Road> roads = new ArrayList<>();

    public static void main(String[] args) {
        n = InputReader.nextInt();
        m = InputReader.nextInt();
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 1; i <= m; i++) {
            int u = InputReader.nextInt();
            int v = InputReader.nextInt();
            int c = InputReader.nextInt();
            roads.add(new Road(u, v, c));
        }
        Collections.sort(roads);
        int s = 0, max = 0;
        for (Road road : roads) {
            if (union(road.u, road.v)) {
                max = Integer.max(max, road.c);
                s++;
                if (s == n - 1) {
                    System.out.printf("%d %d", s, max);
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

    static class Road implements Comparable<Road> {
        int u, v, c;

        public Road(int u, int v, int c) {
            this.u = u;
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Road o) {
            return this.c - o.c;
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
