package level2.mission19;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * P1255 数楼梯
 *
 * @author ajacker
 * @date 2019/12/5 16:56
 */
public class P1255 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger[] dp = new BigInteger[n + 5];
        dp[0] = new BigInteger("0");
        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("2");
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }
        System.out.print(dp[n]);
    }
}
