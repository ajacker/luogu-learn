package level2.mission13;

import java.util.Scanner;

/**
 * P1115 最大子段和
 *
 * @author ajacker
 * @date 2019/12/2 22:33
 */
public class P1115 {

    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += sc.nextInt();
            max = Integer.max(sum, max);
            sum = Integer.max(sum, 0);
        }
        System.out.print(max);
    }

}
