package level1.mission6;

import java.util.Scanner;

/**
 * P1036 选数
 *
 * @author ajacker
 * @date 2019/11/23 22:59
 */
public class P1036 {
    static int[] nums;
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        process(0, 0, k);
        System.out.println(count);
    }

    /**
     * 递归组合数并加起来
     *
     * @param num   当前累加和
     * @param start 搜索起始index
     * @param k     还需要选择几个数
     */
    public static void process(long num, int start, int k) {
        if (k == 0) {
            if (judge(num)) {
                count++;
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] != -1) {
                int selected = nums[i];
                nums[i] = -1;
                process(num + selected, i, k - 1);
                nums[i] = selected;
            }
        }
    }

    /**
     * 判断一个数是否为素数
     *
     * @param num 要判断的数
     * @return
     */
    public static boolean judge(long num) {
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
