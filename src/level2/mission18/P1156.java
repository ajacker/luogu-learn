package level2.mission18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * P1156 垃圾陷阱
 *
 * @author ajacker
 * @date 2019/12/15 20:50
 */
public class P1156 {
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    private static int D;
    private static int G;
    private static Rubbish[] rubbishes;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        in.nextToken();
        D = ((int) in.nval);
        in.nextToken();
        G = ((int) in.nval);
        rubbishes = new Rubbish[G + 1];
        dp = new int[G + 1][D + 1];
        for (int i = 1; i <= G; i++) {
            in.nextToken();
            int T = ((int) in.nval);
            in.nextToken();
            int F = ((int) in.nval);
            in.nextToken();
            int H = ((int) in.nval);
            rubbishes[i] = new Rubbish(T, F, H);
        }
        //按照时间排序
        Arrays.sort(rubbishes, 1, rubbishes.length);
        dp[0][0] = 10;
        //dp[i][j]表示当扔下第i个垃圾时，高度为j此时的还可以存活多久
        for (int i = 0; i < G; i++) {
            for (int j = 0; j <= D; j++) {
                if (dp[i][j] >= rubbishes[i + 1].t) {
                    int newH = j + rubbishes[i + 1].h;
                    if (newH >= D) {
                        System.out.println(rubbishes[i + 1].t);
                        return;
                    }
                    //当不选用这个垃圾来当垫子时：吃垃圾
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + rubbishes[i + 1].f);
                    dp[i + 1][newH] = Math.max(dp[i + 1][newH], dp[i][j]);
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= G; i++) {
            res = Math.max(res, dp[i][0]);
        }
        System.out.println(res);

    }

    static class Rubbish implements Comparable<Rubbish> {
        int t, f, h;

        public Rubbish(int t, int f, int h) {
            this.t = t;
            this.f = f;
            this.h = h;
        }


        @Override
        public int compareTo(Rubbish o) {
            return this.t - o.t;
        }
    }
}
