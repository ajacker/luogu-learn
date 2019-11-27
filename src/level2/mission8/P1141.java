package level2.mission8;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * P1141 01迷宫
 *
 * @author ajacker
 * @date 2019/11/28 0:19
 */
public class P1141 {

    private static int n;
    private static int m;
    private static int[][] visited;
    private static boolean[][] map;
    private static int[] result;
    private static int[][] dirs = new int[][]{
            {0, 1},
            {0, -1},
            {-1, 0},
            {1, 0}
    };

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = InputReader.nextInt();
        visited = new int[n][n];
        map = new boolean[n][n];
        m = InputReader.nextInt();
        result = new int[m + 1];
        //读入地图
        for (int i = 0; i < n; i++) {
            String str = InputReader.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) == '1';
            }
        }
        int[][] input = new int[m][2];
        //读入起始点
        for (int i = 0; i < m; i++) {
            input[i][0] = InputReader.nextInt() - 1;
            input[i][1] = InputReader.nextInt() - 1;

        }
        for (int i = 0; i < m; i++) {
            int x = input[i][0];
            int y = input[i][1];
            out.println(bfs(x, y, i + 1));
        }
        out.flush();
    }

    /**
     * bfs
     *
     * @param x 起始x
     * @param y 起始y
     * @param t 第几次搜索
     * @return 能走几个位置
     */
    public static int bfs(int x, int y, int t) {
        //如果x，y点在之前的搜索中已经有结果就返回
        if (result[visited[x][y]] != 0) {
            return result[visited[x][y]];
        }
        int count = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        queue.offer(y);
        visited[x][y] = t;
        while (!queue.isEmpty()) {
            int a = queue.poll();
            int b = queue.poll();
            boolean cur = map[a][b];
            for (int i = 0; i < 4; i++) {
                int newA = a + dirs[i][0];
                int newB = b + dirs[i][1];
                if (check(newA, newB, cur, t)) {
                    //搜索过的区域赋值为t
                    visited[newA][newB] = t;
                    ++count;
                    queue.offer(newA);
                    queue.offer(newB);
                }
            }
        }
        //从这些区域搜都是一样的结果
        return result[t] = count;
    }

    /**
     * 检查是否可以走
     *
     * @param x   x
     * @param y   y
     * @param pre 前驱的值
     * @param t   搜索类次
     * @return 是否可走
     */
    public static boolean check(int x, int y, boolean pre, int t) {
        if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y] == t) {
            return false;
        }
        return pre != map[x][y];
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
