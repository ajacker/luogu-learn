package level2.mission8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * P1162 填涂颜色
 *
 * @author ajacker
 * @date 2019/11/28 9:30
 */
public class P1162 {
    static int n;
    static int[][] map;
    static int[][] dirs = new int[][]{
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public static void main(String[] args) {
        n = InputReader.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = InputReader.nextInt();
            }
        }
        //从边界染成3，根据题目可知，能和边界连成一块的0不是我们的目标
        for (int i = 0; i < n; i++) {
            bfs(0, i);
            bfs(i, 0);
            bfs(n - 1, i);
            bfs(i, n - 1);
        }
        StringBuilder sb = new StringBuilder();
        //将边界的复原，然后其余的0就是被包围的
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 3) {
                    sb.append(0);
                } else if (map[i][j] == 0) {
                    sb.append(2);
                } else {
                    sb.append(1);
                }
                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());

    }

    static void bfs(int x, int y) {
        if (map[x][y] == 0) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(x);
            queue.offer(y);
            map[x][y] = 3;
            while (!queue.isEmpty()) {
                int a = queue.poll();
                int b = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int newA = a + dirs[i][0];
                    int newB = b + dirs[i][1];
                    if (check(newA, newB)) {
                        map[newA][newB] = 3;
                        queue.offer(newA);
                        queue.offer(newB);
                    }
                }
            }
        }
    }

    static boolean check(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n && map[x][y] == 0;
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
