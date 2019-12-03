package level2.mission15;

import java.util.Scanner;

/**
 * P1049 装箱问题
 *
 * @author ajacker
 * @date 2019/12/3 22:51
 */
public class P1049 {
    static int V;
    static int n;
    static int[] size;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        n = sc.nextInt();
        size = new int[n + 1];
        dp = new int[n + 1][V + 1];
        for (int i = 1; i <= n; i++) {
            size[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= V; j++) {
                if (size[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    int v1 = dp[i - 1][j - size[i]] + size[i];
                    int v21 = dp[i - 1][j];
                    dp[i][j] = Integer.max(v1, v21);
                }
            }
        }
        System.out.print(V - dp[n][V]);
    }
}
