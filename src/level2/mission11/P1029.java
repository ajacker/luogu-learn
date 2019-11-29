package level2.mission11;

import java.util.Scanner;

/**
 * P1029 最大公约数和最小公倍数问题
 *
 * @author ajacker
 * @date 2019/11/29 23:48
 */
public class P1029 {

    private static int x;
    private static int y;
    private static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();
        for (int i = x; i <= y; i++) {
            //最大公约数和最小公倍数的乘积就是原两个数的积
            //这两个数的分别是 x * y % i 和  x * y / i
            if (x * y % i == 0) {
                if (cal1(i, x * y / i) == x) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    /**
     * 求最大公约数
     *
     * @param x
     * @param y
     * @return
     */
    static int cal1(int x, int y) {
        for (int i = Integer.min(x, y); i >= 1; i--) {
            if (x % i == 0 && y % i == 0) {
                return i;
            }
        }
        return -1;
    }


}
