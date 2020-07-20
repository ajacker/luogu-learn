package T100;

import java.util.Scanner;

/**
 * P2433 【深基1-2】小学数学 N 合一
 *
 * @author ajacker
 * @date 2020/7/20 18:20
 */
public class P2433 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        double PI = 3.141593;
        switch (T) {
            case 1:
                System.out.println("I love Luogu!");
                break;
            case 2:
                System.out.print(6 + " ");
                System.out.println(10 - 2 - 4);
                break;
            case 3:
                System.out.println(3);
                System.out.println(12);
                System.out.println(2);
                break;
            case 4:
                System.out.printf("%.3f", 500 / 3f);
                break;
            case 5:
                System.out.println((260 + 220) / (20 + 12));
                break;
            case 6:
                System.out.printf("%.4f", Math.sqrt(6 * 6 + 9 * 9));
                break;
            case 7:
                System.out.println(100 + 10);
                System.out.println(100 + 10 - 20);
                System.out.println(0);
                break;
            case 8:
                System.out.println(31.4159);
                System.out.println(78.5398);
                System.out.print(523.599);
                break;
            case 9:
                System.out.println((((1 + 1) * 2 + 1) * 2 + 1) * 2);
                break;
            case 10:
                System.out.println(9);
                break;
            case 11:
                System.out.printf("%.4f", 100 / 3f);
                break;
            case 12:
                System.out.println('M' - 'A' + 1);
                System.out.println((char) ('A' + 18 - 1));
                break;
            case 13:
                double V = 4 / 3f * PI * Math.pow(4, 3) + 4 / 3f * PI * Math.pow(10, 3);
                System.out.println(((int) Math.pow(V, 1 / 3f)));
                break;
            case 14:
                //(110 - i)  (10 + i) = 3500
                int[] a = new int[2];
                int j = 0;
                for (int i = 0; i < 100; i++) {
                    if ((110 - i) * (10 + i) == 3500) {
                        a[j++] = 110 - i;
                    }
                }
                System.out.println(Math.min(a[0], a[1]));
                break;
            default:
                break;
        }
    }
}
