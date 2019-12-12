package level2.mission18;

import java.util.Arrays;
import java.util.Scanner;

/**
 * P1052 过河
 *
 * @author ajacker
 * @date 2019/12/12 10:31
 */
public class P1052 {
    /**
     * 独木桥长度
     */
    private static int L;
    /**
     * 最小跳跃
     */
    private static int S;
    /**
     * 最大跳跃
     */
    private static int T;
    /**
     * 石子个数
     */
    private static int M;
    /**
     * 石子位置
     */
    private static int[] dp;
    private static int[] stone;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        S = sc.nextInt();
        T = sc.nextInt();
        M = sc.nextInt();
        if (S == T) {
            int count = 0;
            for (int i = 1; i <= M; i++) {
                count += sc.nextInt() % S == 0 ? 1 : 0;
            }
            System.out.println(count);
        } else {
            dp = new int[100005];
            int[] flag = new int[100005];
            stone = new int[M + 1];
            for (int i = 1; i <= M; i++) {
                stone[i] = sc.nextInt();
            }
            Arrays.sort(stone);
            dp[M + 1] = Integer.min(L - stone[M], 100);
            int t = 0;
            for (int i = 1; i <= M; i++) {
                dp[i] = Integer.min(stone[i] - stone[i - 1], 90);
                t += dp[i];
                flag[t] = 1;
            }
            t += dp[M + 1];
            for (int i = 1; i <= t + 9; i++) {
                dp[i] = Integer.MAX_VALUE;
                for (int j = S; j <= T; j++) {
                    if (i >= j) {
                        dp[i] = Integer.min(dp[i], dp[i - j] + flag[i]);
                    }
                }
            }
            int minn = 1000000;
            for (int i = t; i <= t + 9; i++) {
                minn = Integer.min(minn, dp[i]);
            }
            System.out.printf("%d", minn);
        }

    }
}
