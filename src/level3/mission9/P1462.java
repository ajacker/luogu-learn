package level3.mission9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * P1462 通往奥格瑞玛的道路
 * 最短路径
 *
 * @author ajacker
 * @date 2019/12/9 12:38
 */
public class P1462 {
    private static int n;
    private static int m;
    private static long b;
    private static long[] cost;
    private static ArrayList<Edge>[] map;

    public static void main(String[] args) {
        n = InputReader.nextInt();
        m = InputReader.nextInt();
        b = InputReader.nextLong();
        cost = new long[n + 1];
        map = new ArrayList[n + 1];
        Long max = Long.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
            long fi = InputReader.nextLong();
            cost[i] = fi;
            max = Long.max(max, fi);
        }
        for (int i = 1; i <= m; i++) {
            int ai = InputReader.nextInt();
            int bi = InputReader.nextInt();
            int ci = InputReader.nextInt();
            map[ai].add(new Edge(bi, ci, cost[bi]));
            map[bi].add(new Edge(ai, ci, cost[ai]));
        }
        //在可能的答案区间二分搜索
        long ans = -1, l = 1, r = max;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (spfa((int) mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(ans == -1 ? "AFK" : ans);

    }

    static boolean spfa(int top) {
        //判断这个花费可不可能为答案
        if (cost[1] > top) {
            return false;
        }
        boolean[] inQueue = new boolean[n + 1];
        long[] damages = new long[n + 1];
        Arrays.fill(damages, Long.MAX_VALUE);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        inQueue[1] = true;
        damages[1] = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            inQueue[u] = false;
            for (Edge edge : map[u]) {
                int v = edge.v;
                if (cost[v] <= top && damages[u] + edge.damage < damages[v]) {
                    damages[v] = damages[u] + edge.damage;
                    if (!inQueue[v]) {
                        queue.offer(v);
                        inQueue[v] = true;
                    }
                }
            }
        }
        //判断是否在收取费用最小值为x的时候走完
        return damages[n] <= b;
    }


    static class Edge {
        int v;
        long damage, cost;

        public Edge(int v, long damage, long cost) {
            this.v = v;
            this.damage = damage;
            this.cost = cost;
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

        static long nextLong() {
            return Long.parseLong(next());
        }
    }
}
