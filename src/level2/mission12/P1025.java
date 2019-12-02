package level2.mission12;

import java.util.Scanner;

/**
 * P1025 数的划分
 *
 * @author ajacker
 * @date 2019/12/2 8:19
 */
public class P1025 {

    private static int sum;
    private static int kind;
    private static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sum = sc.nextInt();
        kind = sc.nextInt();
        ans = dfs(sum, kind, 1);
        System.out.print(ans);

    }

    /**
     * 将n拆成k个数有几种不同的拆法
     *
     * @param n    n
     * @param k    k
     * @param prev 上一次拆的时候选择的数
     * @return 拆法个数
     */
    private static int dfs(int n, int k, int prev) {
        if (k == 1) {
            //当只有一次需要拆的时候
            //这个数字是否比上个数字大？
            return n >= prev ? 1 : 0;
        } else {
            int count = 0;
            //从prev到n是因为拆n的时候不可能拆成0和n，并且保证从前一个数字开始拆（从小到大，保证只出现一次）
            for (int i = prev; i < n; i++) {
                count += dfs(n - i, k - 1, i);
            }
            return count;
        }
    }
}
