package level2.mission17;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * P1387 最大正方形
 *
 * @author ajacker
 * @date 2019/12/11 14:59
 */
public class P1387 {

    private static int n;
    private static int m;
    private static int[][] map, dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 1];
        int ans = 0;
        //dp[i][j]表示以节点i,j为右下角，可构成的最大正方形的边长。并且表明包括节点i，j在内向上x个节点，向左x个节点扫过的正方形中所有a值都为1
        //也就是以i，j为正方形右下角的时候的最大边长
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    //选择上，左，左上中，能扩展情况的最小边（因为问的正方形）
                    dp[i][j] = IntStream.of(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]).min().getAsInt() + 1;
                }
                ans = Integer.max(ans, dp[i][j]);
            }
        }
        System.out.println(ans);
    }
}
