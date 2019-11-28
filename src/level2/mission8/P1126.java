package level2.mission8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * P1126 机器人搬重物
 *
 * @author ajacker
 * @date 2019/11/28 11:19
 */
public class P1126 {

    private static int n, m;
    private static int startX, startY, endX, endY;
    /**
     * 是否访问过，第三维度是方向
     * 0:E -1
     * 1:S  -2
     * 2:W  -4
     * 3:N  -8
     */
    private static boolean[][][] visited;
    /**
     * 地图,true代表有障碍
     */
    private static boolean[][] map;
    /**
     * 操作集合
     */
    private static Action[] actions = new Action[]{
            robot -> robot.move(1),
            robot -> robot.move(2),
            robot -> robot.move(3),
            robot -> robot.turn(true),
            robot -> robot.turn(false)
    };

    public static void main(String[] args) {
        n = InputReader.nextInt();
        m = InputReader.nextInt();
        map = new boolean[n][m];
        visited = new boolean[n][m][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cur = InputReader.nextInt();
                //将以这个点为右下角的点设置为障碍
                if (cur == 1) {
                    for (int p = 0; p < 2; p++) {
                        for (int q = 0; q < 2; q++) {
                            if (i - p >= 0 && j - q >= 0) {
                                map[i - p][j - q] = true;
                            }
                        }
                    }
                }
            }
        }
        startX = InputReader.nextInt() - 1;
        startY = InputReader.nextInt() - 1;
        endX = InputReader.nextInt() - 1;
        endY = InputReader.nextInt() - 1;
        int dir = "ESWN".indexOf(InputReader.next());
        Robot start = new Robot(startX, startY, dir);
        System.out.print(bfs(start));
    }

    static int bfs(Robot start) {
        if (!start.check()) {
            return -1;
        }
        Queue<Robot> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.x][start.y][start.face] = true;
        while (!queue.isEmpty()) {
            Robot cur = queue.poll();
            if (cur.x == endX && cur.y == endY) {
                return cur.time;
            }
            //尝试每种操作
            for (int i = 0; i < actions.length; i++) {
                Robot next = cur.cloneRobot();
                //takeAction的时候已经检查了合法性
                if (actions[i].takeAction(next) && !visited[next.x][next.y][next.face]) {
                    visited[next.x][next.y][next.face] = true;
                    queue.offer(next);
                }
            }
        }
        return -1;
    }

    interface Action {
        boolean takeAction(Robot robot);
    }

    static class Robot {
        int x, y;
        int face;
        int time;

        public Robot(int x, int y, int face) {
            this.x = x;
            this.y = y;
            this.face = face;
        }

        /**
         * 要一步一步走，不能直接+step，会跳过障碍物
         *
         * @param step
         */
        boolean move(int step) {
            time++;
            for (int i = 0; i < step; i++) {
                switch (face) {
                    case 0:
                        ++y;
                        break;
                    case 1:
                        ++x;
                        break;
                    case 2:
                        --y;
                        break;
                    case 3:
                        --x;
                        break;
                    default:
                        break;
                }
                if (!check()) {
                    return false;
                }
            }
            return true;
        }

        boolean turn(boolean isLeft) {
            time++;
            if (isLeft) {
                face = (face - 1 + 4) % 4;
            } else {
                face = (face + 1) % 4;
            }
            return true;
        }

        boolean check() {
            //注意下右边和下边，不能最后一行，因为机器人占四格
            if (x < 0 || x >= n - 1 || y < 0 || y >= m - 1 || map[x][y]) {
                return false;
            }
            return true;
        }

        protected Robot cloneRobot() {
            Robot robot = new Robot(x, y, face);
            robot.time = time;
            return robot;
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
