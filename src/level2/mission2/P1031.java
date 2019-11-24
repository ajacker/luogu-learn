package level2.mission2;

import java.util.Scanner;

/**
 * P1031 均分纸牌
 *
 * @author ajacker
 * @date 2019/11/24 19:38
 */
public class P1031 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //纸牌堆
        int[] stack = new int[n];
        //求和
        int sum = 0;
        for (int i = 0; i < n; i++) {
            stack[i] = scanner.nextInt();
            sum += stack[i];
        }
        //求平均值
        int average = sum / n;
        //移动次数
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (stack[i] != average) {
                //逐渐移动牌
                stack[i + 1] += stack[i] - average;
                stack[i] -= stack[i] - average;
                count++;
            }
        }
        System.out.println(count);

    }
}
