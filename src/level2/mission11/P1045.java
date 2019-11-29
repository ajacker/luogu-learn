package level2.mission11;

import java.util.Scanner;

/**
 * P1045 麦森数
 *
 * @author ajacker
 * @date 2019/11/29 21:30
 */
public class P1045 {

    private static final double LG2_10 = 0.30102999566398114;
    private static int p;
    private static long[] a = new long[510];

    static {
        a[500] = 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        p = sc.nextInt();
        //2的p次方-1 有p个1（二进制）
        System.out.println(((int) (p * LG2_10)) + 1);
        long tmp = pow2(32);
        int t32 = p / 32;
        int t1 = p - t32 * 32;

        for (int T = 1; T <= t32; T++) {
            for (int i = 500; i >= 1; i--) {
                a[i] *= tmp;
            }
            for (int i = 500; i >= 1; i--) {
                a[i - 1] += a[i] / 10;
                a[i] %= 10;
            }
        }
        for (int T = 1; T <= t1; T++) {
            for (int i = 500; i >= 1; i--) {
                a[i] *= 2;
            }
            for (int i = 500; i >= 1; i--) {
                a[i - 1] += a[i] / 10;
                a[i] %= 10;
            }
        }
        a[500]--;

        for (int i = 1; i <= 500; i++) {
            System.out.print(a[i]);
            if (i % 50 == 0) {
                System.out.println();
            }
        }
    }

    public static long pow2(int n) {
        long res = 1;
        long b = 2;
        while (n != 0) {
            if ((n & 1) == 1) {
                res = res * b;
            }
            b = (b * b);
            n >>>= 1;
        }
        return res;
    }
}
