package level1.mission2;

import java.util.Scanner;

/**
 * 买铅笔
 *
 * @author ajacker
 * @date 2019/11/23 19:24
 */
public class P1909 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            int count = scanner.nextInt();
            int price = scanner.nextInt();
            int amount = (int) Math.ceil(n * 1d / count);
            minCost = Integer.min(amount * price, minCost);
        }
        System.out.println(minCost);
    }
}
