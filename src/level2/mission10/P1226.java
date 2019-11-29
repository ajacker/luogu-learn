package level2.mission10;

import java.util.Scanner;

/**
 * P1226 【模板】快速幂||取余运算
 *
 * @author ajacker
 * @date 2019/11/29 11:38
 */
public class P1226 {

    private static long b;
    private static long p;
    private static long k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        b = sc.nextInt();
        p = sc.nextInt();
        k = sc.nextInt();
        long res = cal(b, p, k);
        System.out.printf("%d^%d mod %d=%d", b, p, k, res);
    }

    public static long cal(long b, long p, long k) {
        long res = 1;
        while (p != 0) {
            if ((p & 1) == 1) {
                res = (res * b) % k;
            }
            b = (b * b) % k;
            p >>>= 1;
        }
        return res % k;
    }
}
