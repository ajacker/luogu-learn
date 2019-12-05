package level2.mission16;

import java.util.Scanner;

/**
 * P1091 合唱队形
 *
 * @author ajacker
 * @date 2019/12/5 16:31
 */
public class P1091 {

    private static int N;
    private static int[] height;
    private static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        height = new int[N + 1];
        dp = new int[2][N + 1];
        for (int i = 1; i <= N; i++) {
            height[i] = sc.nextInt();
        }
        //从前往后求最长上升子序列
        dp[0][0] = 0;
        for (int i = 1; i <= N; i++) {
            dp[0][i] = 1;
            for (int j = 0; j < i; j++) {
                if (height[i] > height[j]) {
                    dp[0][i] = Integer.max(dp[0][i], dp[0][j] + 1);
                }
            }
        }
        //从后往前求最长上下降子序列
        for (int i = N; i >= 1; i--) {
            dp[1][i] = 1;
            for (int j = i + 1; j <= N; j++) {
                if (height[i] > height[j]) {
                    dp[1][i] = Integer.max(dp[1][i], dp[1][j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= N; i++) {
            //遍历以谁为最高的时候，能够保留的人数最多
            res = Integer.max(res, dp[0][i] + dp[1][i] - 1);
        }
        System.out.print(N - res);
    }
}
