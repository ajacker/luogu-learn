package level2.mission7;

import java.util.Scanner;

/**
 * P1605 迷宫
 *
 * @author ajacker
 * @date 2019/11/27 15:30
 */
public class P1605 {
    static int count;
    private static int N;
    private static int M;
    private static int T;
    private static int startX;
    private static int startY;
    private static int endX;
    private static int endY;
    private static boolean[][] visited;
    private static int[][] dirs = new int[][]{
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        T = sc.nextInt();
        startX = sc.nextInt() - 1;
        startY = sc.nextInt() - 1;
        endX = sc.nextInt() - 1;
        endY = sc.nextInt() - 1;
        visited = new boolean[N][M];
        for (int i = 0; i < T; i++) {
            visited[sc.nextInt() - 1][sc.nextInt() - 1] = true;
        }
        if (visited[endX][endY]) {
            System.out.print(0);
        } else {
            visited[startX][startY] = true;
            dfs(startX, startY);
            System.out.print(count);
        }
    }

    public static void dfs(int x, int y) {
        if (x == endX && y == endY) {
            count++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int newX = x + dirs[i][0];
            int newY = y + dirs[i][1];
            if (check(newX, newY)) {
                visited[newX][newY] = true;
                dfs(newX, newY);
                visited[newX][newY] = false;
            }
        }
    }

    public static boolean check(int i, int j) {
        if (i >= 0 && i < N && j >= 0 && j < M) {
            return !visited[i][j];
        } else {
            return false;
        }
    }
}
