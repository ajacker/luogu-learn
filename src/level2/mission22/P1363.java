package level2.mission22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Stack;

/**
 * P1363 幻象迷宫
 *
 * @author ajacker
 * @date 2019/12/14 11:22
 */
public class P1363 {
    static char[][] map = new char[1505][1505];
    private static int[][] dirs = new int[][]{
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.ordinaryChar('.');
        in.ordinaryChar('S');
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int n = (int) in.nval;
            in.nextToken();
            int m = (int) in.nval;
            int x = 0, y = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    in.nextToken();
                    map[i][j] = ((char) in.ttype);
                    if (map[i][j] == 'S') {
                        x = i;
                        y = j;
                    }
                }
            }
            System.out.println(dfs(map, n, m, x, y) ? "Yes" : "No");
            System.gc();
        }
    }

    static boolean dfs(char[][] map, int n, int m, int x, int y) {
        Stack<Short> stack = new Stack<>();
        short[][][] visited = new short[n][m][3];
        stack.push((short) y);
        stack.push((short) x);
        stack.push((short) y);
        stack.push((short) x);
        while (!stack.isEmpty()) {
            int X = stack.pop();
            int Y = stack.pop();
            int curX = stack.pop();
            int curY = stack.pop();
            if (visited[curX][curY][0] == 1 && (visited[curX][curY][1] != X || visited[curX][curY][2] != Y)) {
                return true;
            }
            visited[curX][curY][0] = 1;
            visited[curX][curY][1] = (short) X;
            visited[curX][curY][2] = (short) Y;
            for (int i = 0; i < 4; i++) {
                int tempX = X + dirs[i][0];
                int tempY = Y + dirs[i][1];
                int nextX = (curX + dirs[i][0] + n) % n;
                int nextY = (curY + dirs[i][1] + m) % m;
                if (map[nextX][nextY] != '#') {
                    if (visited[nextX][nextY][1] != tempX
                            || (visited[nextX][nextY][2] != tempY
                            || visited[nextX][nextY][0] != 1)) {
                        stack.push((short) nextY);
                        stack.push((short) nextX);
                        stack.push((short) tempY);
                        stack.push((short) tempX);
                    }
                }
            }
        }
        return false;

    }
}
