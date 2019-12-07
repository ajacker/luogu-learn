package level2.mission19;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * P1604 B进制星球
 *
 * @author ajacker
 * @date 2019/12/7 10:43
 */
public class P1604 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        BigInteger m = sc.nextBigInteger(b);
        BigInteger n = sc.nextBigInteger(b);
        System.out.println(m.add(n).toString(b).toUpperCase());
    }
}
