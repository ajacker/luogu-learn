package level2.mission16;

import java.util.Scanner;

/**
 * P1880 [NOI1995]石子合并
 *
 * @author ajacker
 * @date 2019/12/4 18:01
 */
public class P1880 {

    private static int N;
    private static int[] stack;
    private static int[][] min;
    private static int[][] max;
    private static int[] sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        //石子
        stack = new int[2 * N + 1];
        sum = new int[2 * N + 1];
        min = new int[2 * N + 1][2 * N + 1];
        max = new int[2 * N + 1][2 * N + 1];
        for (int i = 1; i <= N; i++) {
            stack[i] = sc.nextInt();
            stack[N + i] = stack[i];
        }
        //计算前缀和
        for (int i = 1; i <= 2 * N; i++) {
            sum[i] = sum[i - 1] + stack[i];
        }
        for (int p = 1; p < N; p++) {
            for (int i = 1, j = i + p; (j < 2 * N) && (i < 2 * N); i++, j = i + p) {
                min[i][j] = Integer.MAX_VALUE;
                max[i][j] = Integer.MIN_VALUE;
                //计算每一种划分的情况
                for (int k = i; k < j; k++) {
                    min[i][j] = Integer.min(min[i][j], min[i][k] + min[k + 1][j] + (sum[j] - sum[i - 1]));
                    max[i][j] = Integer.max(max[i][j], max[i][k] + max[k + 1][j] + (sum[j] - sum[i - 1]));
                }

            }
        }
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        //在找到所有办法中最小/最大的
        for (int i = 1; i <= N; i++) {
            minValue = Integer.min(minValue, min[i][i + N - 1]);
            maxValue = Integer.max(maxValue, max[i][i + N - 1]);
        }
        System.out.println(minValue);
        System.out.println(maxValue);
    }
}
