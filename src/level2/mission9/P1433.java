package level2.mission9;

import java.util.Scanner;

/**
 * P1433 吃奶酪
 *
 * @author ajacker
 * @date 2019/11/28 22:41
 */
public class P1433 {

    private static int n;
    private static Pos[] points;
    private static boolean[] visited;
    private static double min = Double.MAX_VALUE;
    private static Pos pre;
    private static double dis;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        points = new Pos[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Pos(sc.nextDouble(), sc.nextDouble());
        }
        Pos start = new Pos(0, 0);
        pre = start;
        dfs(0);
        System.out.printf("%.2f", min);
    }

    static void dfs(int count) {
        //剪枝，如果当前路径已经超过了之前搜过的最小值，就不要搜了
        if (dis > min) {
            return;
        }
        if (count == n) {
            min = Math.min(min, dis);
        }
        for (int i = 0; i < points.length; i++) {
            Pos temp = pre;
            if (!visited[i]) {
                dis += pre.getDistance(points[i]);
                pre = points[i];
                visited[i] = true;
                dfs(count + 1);
                visited[i] = false;
                pre = temp;
                dis -= pre.getDistance(points[i]);
            }
        }
    }

    static class Pos {
        double x;
        double y;

        public Pos(double x, double y) {
            this.x = x;
            this.y = y;
        }

        double getDistance(Pos o) {
            return Math.sqrt((x - o.x) * (x - o.x) + (y - o.y) * (y - o.y));
        }
    }
}
