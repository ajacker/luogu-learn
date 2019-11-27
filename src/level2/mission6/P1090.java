package level2.mission6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * P1090 合并果子
 *
 * @author ajacker
 * @date 2019/11/26 21:19
 */
public class P1090 {
    /**
     * 果子种类数
     */
    static int n;
    /**
     * 第i种果子数目
     */
    static int[] amounts;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        amounts = new int[n];
        for (int i = 0; i < n; i++) {
            amounts[i] = sc.nextInt();
        }
        Arrays.sort(amounts);
        int start = 0, cost = 0;
        while (start + 1 < n) {
            //合并最小的两堆到start+1
            amounts[start + 1] += amounts[start];
            cost += amounts[start + 1];
            //将合并后的数字交换到合适位置
            int pos = start + 1;
            while (pos + 1 < amounts.length && amounts[pos] > amounts[pos + 1]) {
                if (amounts[pos] != amounts[pos + 1]) {
                    amounts[pos] ^= amounts[pos + 1];
                    amounts[pos + 1] ^= amounts[pos];
                    amounts[pos] ^= amounts[pos + 1];
                }
                pos++;
            }
            start++;
        }
        System.out.println(cost);
    }
}
