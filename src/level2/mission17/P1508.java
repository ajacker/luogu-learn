package level2.mission17;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * P1508 Likecloud-吃、吃、吃
 *
 * @author ajacker
 * @date 2019/12/11 11:58
 */
public class P1508 {

    private static int n;
    private static int m;
    private static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        map = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        find();
    }

    public static void find() {
        int[][] dp = new int[m + 2][n + 2];
        int mid = n / 2 + 1;
        //防止从不可走的点走过去
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -100000);
        }
        dp[m][mid] = map[m][mid];
        if (mid - 1 >= 1) {
            dp[m][mid - 1] = map[m][mid - 1];
        }
        if (mid + 1 <= n) {
            dp[m][mid + 1] = map[m][mid + 1];
        }
        for (int a = m - 1; a >= 0; a--) {
            for (int b = 1; b <= n; b++) {
                dp[a][b] = IntStream.of(dp[a + 1][b - 1], dp[a + 1][b], dp[a + 1][b + 1]).max().getAsInt() + map[a][b];
            }
        }
        int res = Arrays.stream(dp[0]).max().getAsInt();
        System.out.print(res);
    }
}
