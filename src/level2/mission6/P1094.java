package level2.mission6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * P1094 纪念品分组
 *
 * @author ajacker
 * @date 2019/11/27 11:38
 */
public class P1094 {
    /**
     * 每组纪念品价格之和的上上限
     */
    private static int w;
    /**
     * 购来的纪念品的总件数
     */
    private static int n;
    /**
     * 所对应纪念品的价格
     */
    private static Integer[] prices;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        w = sc.nextInt();
        n = sc.nextInt();
        prices = new Integer[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        Arrays.sort(prices, Comparator.reverseOrder());
        int count = 0;
        // 从前后开始分组
        int i = 0, j = n - 1;
        while (i <= j) {
            //先放大的，在尝试放小的，能放就放，不能就继续放下一个最大的
            if (prices[i++] + prices[j] <= w) {
                j--;
            }
            count++;
        }
        System.out.println(count);

    }
}
