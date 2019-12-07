package level2.mission19;

import java.util.Scanner;

/**
 * P2142 高精度减法
 *
 * @author ajacker
 * @date 2019/12/7 10:52
 */
public class P2142 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(sc.nextBigInteger().subtract(sc.nextBigInteger()));
    }
}
