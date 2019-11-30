package level2.mission12;

import java.util.Scanner;

/**
 * P1192 台阶问题
 *
 * @author ajacker
 * @date 2019/11/30 17:16
 */
public class P1192 {

    private static int n;
    private static int k;
    private static int dp[] = new int[100010];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        System.out.print(fun(n));
    }

    /**
     * 动态规划解法
     *
     * @param n
     * @return
     */
    public static int fun(int n) {
        //走一级台阶只有一种走法
        dp[1] = 1;
        for (int p = 2; p <= n; p++) {
            int res = 0;
            //在之前的k步都可以一步走过来
            for (int i = 1; i <= Integer.min(p - 1, k); i++) {
                res = (res + dp[p - i]) % 100003;
            }
            //如果最多能一次走k级台阶，那么如果p能一次走，就多了一种走法
            if (p <= k) {
                res++;
            }
            dp[p] = res % 100003;
        }
        return dp[n];
    }
}
