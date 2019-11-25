package level2.mission3;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * P1781 宇宙总统
 *
 * @author ajacker
 * @date 2019/11/25 23:04
 */
public class P1781 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int maxId = 0;
        BigInteger max = BigInteger.valueOf(0);
        for (int i = 0; i < n; i++) {
            BigInteger temp = scanner.nextBigInteger();
            if (temp.compareTo(max) > 0) {
                maxId = i + 1;
                max = temp;
            }
        }
        System.out.println(maxId);
        System.out.print(max);

    }
}
