package level2.mission25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * P3367 【模板】并查集
 *
 * @author ajacker
 * @date 2019/12/5 22:03
 */
public class P3367 {

    private static int N, M;
    private static int[] parent;

    public static void main(String[] args) {
        N = InputReader.nextInt();
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        M = InputReader.nextInt();
        for (int i = 0; i < M; i++) {
            int z = InputReader.nextInt();
            int x = InputReader.nextInt();
            int y = InputReader.nextInt();
            if (z == 1) {
                //合并
                union(x, y);
            } else {
                //是否在一个结合
                System.out.println(isUnion(x, y) ? "Y" : "N");
            }
        }
    }

    static int find(int i) {
        return i == parent[i] ? i : (parent[i] = find(parent[i]));
    }

    static boolean isUnion(int u, int v) {
        int a = find(u);
        int b = find(v);
        return a == b;
    }

    static void union(int u, int v) {
        int a = find(u);
        int b = find(v);
        if (a != b) {
            parent[a] = b;
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
