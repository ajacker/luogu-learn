package T100;

import java.util.Scanner;

/**
 * P5709 【深基2.习6】Apples Prologue
 *
 * @author ajacker
 * @date 2020/7/20 19:35
 */
public class P5709 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int t = sc.nextInt();
        int s = sc.nextInt();
        if (t == 0) {
            System.out.println(0);
        } else {
            // 能吃n个苹果
            int n = (int) Math.ceil(s * 1f / t);
            // 还剩几个苹果
            System.out.println(Math.max(m - n, 0));
        }
    }
}
