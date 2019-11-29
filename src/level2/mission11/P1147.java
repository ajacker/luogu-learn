package level2.mission11;

import java.util.Scanner;

/**
 * P1147 连续自然数和
 *
 * @author ajacker
 * @date 2019/11/29 23:06
 */
public class P1147 {

    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        solve2();
    }

    /**
     * 暴力
     */
    public static void solve1() {
        int sum, j;
        for (int i = 1; i <= n / 2; i++) {
            sum = 0;
            //枚举每一个i对应的j，这个j是最小的，从i加到j总和大于等于n的自然数
            for (j = i; j < n; j++) {
                //sum记录从i加到j的总和
                sum += j;
                //当sum>=n时，跳出循环
                if (sum >= n) {
                    break;
                }
            }
            if (sum == n) {
                System.out.printf("%d %d\n", i, j);
            }
        }
    }

    /**
     * 尺取法（滑动窗口？）
     * 用i，j代表区间的左右端点
     * 当sum小于目标值M时，将右端点右移（j++），sum会变大
     * 当sum大于目标值M时，将左端点右移（i++），sum会变小
     * 在双指针移动的过程中，如果有sum==M的情况就输出。
     */
    public static void solve2() {
        int sum = 3;
        for (int i = 1, j = 2; i <= n / 2; ) {
            if (sum == n) {
                System.out.printf("%d %d\n", i, j);
                sum -= i;
                i++;
            } else if (sum < n) {
                j++;
                sum += j;
            } else {
                sum -= i;
                i++;
            }
        }
    }
}
