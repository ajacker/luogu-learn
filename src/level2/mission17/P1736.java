package level2.mission17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * P1736 创意吃鱼法
 *
 * @author ajacker
 * @date 2019/12/11 15:22
 */
public class P1736 {

    private static short n;
    private static short m;
    private static short[][] map;
    private static short[][] dp, x, y;
    private static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        in.nextToken();
        n = (short) in.nval;
        in.nextToken();
        m = (short) in.nval;
        map = new short[n + 1][m + 2];
        dp = new short[n + 1][m + 2];
        x = new short[n + 1][m + 2];
        y = new short[n + 1][m + 2];
        int ans = 0;
        //扫描左上-右下
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                in.nextToken();
                map[i][j] = (short) in.nval;
                if (map[i][j] == 1) {
                    dp[i][j] = (short) (Integer.min(dp[i - 1][j - 1], Integer.min(x[i - 1][j], y[i][j - 1])) + 1);
                } else {
                    //x代表从此位置到上面有多少个连续0
                    x[i][j] = (short) (x[i - 1][j] + 1);
                    //y代表从此位置到左面有多少个连续0
                    y[i][j] = (short) (y[i][j - 1] + 1);
                }
                ans = Integer.max(ans, dp[i][j]);
            }
        }
        //扫描右上-左下
        for (int i = 1; i <= n; i++) {
            //记住这次遍历行需要从后往前
            for (int j = m; j >= 1; j--) {
                if (map[i][j] == 1) {
                    dp[i][j] = (short) (Integer.min(dp[i - 1][j + 1], Integer.min(x[i - 1][j], y[i][j + 1])) + 1);
                } else {
                    //x代表从此位置到上面有多少个连续0
                    x[i][j] = (short) (x[i - 1][j] + 1);
                    //y代表从此位置到右面有多少个连续0
                    y[i][j] = (short) (y[i][j + 1] + 1);
                }
                ans = Integer.max(ans, dp[i][j]);
            }
        }
        System.out.println(ans);
    }

}
