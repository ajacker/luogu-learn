package T100;

import java.util.Scanner;

/**
 * P5708 【深基2.习2】三角形面积
 *
 * @author ajacker
 * @date 2020/7/20 18:08
 */
public class P5708 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double p = (a + b + c) / 2;
        System.out.printf("%.1f", Math.sqrt(p * (p - a) * (p - b) * (p - c)));
    }
}
