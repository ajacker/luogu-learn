package T100;

import java.util.Scanner;

/**
 * P5706 【深基2.例8】再分肥宅水
 *
 * @author ajacker
 * @date 2020/7/20 18:05
 */
public class P5706 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double t = sc.nextDouble();
        int n = sc.nextInt();
        System.out.printf("%.3f\n%d", t / n, 2 * n);
    }
}
