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
                if (size[i] <= j) {
                    //优先装第i个之后，加上剩下的空间能装的最优解
                    int v1 = dp[i - 1][j - size[i]] + size[i];
                    //如果不装当前物品，直接和装前面(如果装不下只能选择不装当前物品)
                    int v2 = dp[i - 1][j];
                    //选择能装的最大价值（重量）
                    dp[i][j] = Integer.max(v1, v2);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.print(V - dp[n][V]);
    }
}
