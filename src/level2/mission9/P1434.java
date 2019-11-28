package level2.mission9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * P1434 [SHOI2002]滑雪
 *
 * @author ajacker
 * @date 2019/11/28 17:48
 */
public class P1434 {

    private static int r;
    private static int c;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[][] result;
    private static int[][] dirs = new int[][]{
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public static void main(String[] args) {
        r = InputReader.nextInt();
        c = InputReader.nextInt();
        map = new int[r][c];
        result = new int[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = InputReader.nextInt();
            }
        }
        int res = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                visited[i][j] = true;
                res = Integer.max(res, dfs(i, j));
                visited[i][j] = false;
            }
        }
        System.out.print(res);
    }

    static int dfs(int x, int y) {
        //如果有结果就直接返回
        if (result[x][y] != 0) {
            return result[x][y];
        }
        int maxDepth = 1;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dirs[i][0];
            int nextY = y + dirs[i][1];
            if (nextX >= 0 && nextX < r && nextY >= 0 && nextY < c) {
                if (map[nextX][nextY] < map[x][y] && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    //求所有可能的最大值
                    maxDepth = Integer.max(maxDepth, dfs(nextX, nextY) + 1);
                    visited[nextX][nextY] = false;
                }
            }

        }
        //记录从x，y开始搜索的结果
        return result[x][y] = maxDepth;
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
