package level3.mission10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * P1265 公路修建
 *
 * @author ajacker
 * @date 2019/12/14 22:26
 */
public class P1265 {
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    private static int n;

    private static Point[] points;

    public static void main(String[] args) throws IOException {
        in.nextToken();
        n = (int) in.nval;
        points = new Point[n + 1];
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            int x = (int) in.nval;
            in.nextToken();
            int y = (int) in.nval;
            points[i] = new Point(x, y);
        }
        prim();
    }

    /**
     * prim算法求最小生成树
     */
    static void prim() {
        double[] distance = new double[n + 1];
        Arrays.fill(distance, Double.MAX_VALUE);
        boolean[] visited = new boolean[n + 1];
        distance[1] = 0;
        for (int i = 1; i <= n - 1; i++) {
            int x = 0;
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && (x == 0 || distance[j] < distance[x])) {
                    x = j;
                }
            }
            visited[x] = true;
            for (int y = 1; y <= n; y++) {
                if (!visited[y]) {
                    distance[y] = Math.min(distance[y], points[x].getDistance(points[y]));
                }
            }

        }
        double res = 0;
        for (int i = 1; i <= n; i++) {
            res += distance[i];
        }
        System.out.printf("%.2f", res);
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        double getDistance(Point o) {
            return Math.sqrt(Math.pow(x - o.x, 2) + Math.pow(y - o.y, 2));
        }
    }
}
